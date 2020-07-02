package com.javafxMvc.application;

import com.javafxMvc.l10n.L10n;
import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.method.MethodReflectionLoader;
import com.javafxMvc.reflection.mvc.ControllerReflectionLoader;
import com.javafxMvc.reflection.mvc.InjectReflectionLoader;
import com.javafxMvc.reflection.mvc.ModelReflectionLoader;
import com.javafxMvc.reflection.mvc.ViewReflectionLoader;
import com.javafxMvc.reflection.ValidatorReflectionLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import com.javafxMvc.annotations.*;
import javafx.stage.WindowEvent;
import org.reflections.Reflections;

import java.util.ResourceBundle;

/**
 * The abstract base class for all mvc applications.
 */
public abstract class MVCApplication extends Application {

    /**
     * The mvc map
     */
    protected MvcMap mvcMap = new MvcMap();

    /**
     * Start the application
     *
     * @param stage the main stage
     */
    @Override
    public void start(Stage stage){
        initializeMvc();
        initialize(stage);
    }

    /**
     * Initializes the application.
     *
     * @param stage the main stage
     */
    public void initialize(final Stage stage) {
        setupMainWindowCloseListener(stage);
    }

    /**
     * Is called before the application is closed.
     *
     * @param e the close window event
     */
    public abstract void onClose(WindowEvent e);

    /**
     * Loads the resource bundle to specify the current language.
     *
     * @return the resource bundle
     */
    public abstract ResourceBundle loadResourceBundle();

    private void initializeMvc(){
        Reflections reflections = new Reflections(this.getClass().getPackage().getName());
        ResourceBundle resourceBundle = loadResourceBundle();

        L10n.load(resourceBundle);

        ModelReflectionLoader.load(reflections, mvcMap);
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);
        ControllerReflectionLoader.load(reflections, mvcMap);
        ValidatorReflectionLoader.load(mvcMap.getMvcMap());

        InjectReflectionLoader.load(mvcMap);

        MethodReflectionLoader.load(mvcMap, Bind.class);
        MethodReflectionLoader.load(mvcMap, PostConstruct.class);
    }
    
    private void setupMainWindowCloseListener(final Stage stage){
        stage.setOnCloseRequest(this::onClose);
    }
}