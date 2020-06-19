package com.javafxMvc.application;

import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.method.MethodReflectionLoader;
import com.javafxMvc.reflection.mvc.ControllerReflectionLoader;
import com.javafxMvc.reflection.mvc.InjectReflectionLoader;
import com.javafxMvc.reflection.mvc.ModelReflectionLoader;
import com.javafxMvc.reflection.mvc.ViewReflectionLoader;
import com.javafxMvc.reflection.ValidatorReflectionLoader;
import com.javafxMvc.reflection.L10nReflectionLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import com.javafxMvc.annotations.*;
import javafx.stage.WindowEvent;
import org.reflections.Reflections;

import java.util.ResourceBundle;

/**
 *
 */
public abstract class MVCApplication extends Application {

    /**
     *
     */
    protected MvcMap mvcMap = new MvcMap();

    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage){
        initializeMvc();
        initialize(stage);
    }

    /**
     *
     * @param stage
     */
    public void initialize(final Stage stage) {
        Platform.setImplicitExit(false);
        setupMainWindowCloseListener(stage);
    }

    /**
     *
     * @param e
     */
    public abstract void onClose(WindowEvent e);

    /**
     *
     * @return
     */
    public abstract ResourceBundle loadResourceBundle();

    private void initializeMvc(){
        Reflections reflections = new Reflections(this.getClass().getPackage().getName());
        ResourceBundle resourceBundle = loadResourceBundle();

        ModelReflectionLoader.load(reflections, mvcMap);
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);
        ControllerReflectionLoader.load(reflections, mvcMap);
        ValidatorReflectionLoader.load(mvcMap.getMvcMap());

        InjectReflectionLoader.load(mvcMap);
        L10nReflectionLoader.load(mvcMap.getMvcMap(), resourceBundle);

        MethodReflectionLoader.load(mvcMap, Bind.class);
        MethodReflectionLoader.load(mvcMap, PostConstruct.class);
    }
    
    private void setupMainWindowCloseListener(final Stage stage){
        stage.setOnCloseRequest(this::onClose);
    }
}