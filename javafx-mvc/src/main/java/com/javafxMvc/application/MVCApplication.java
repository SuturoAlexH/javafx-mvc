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

public abstract class MVCApplication extends Application {

   protected MvcMap mvcMap = new MvcMap();

    @Override
    public void start(Stage stage){
        initializeMvc();
        initialize(stage);
    }

    public void initialize(final Stage stage) {
        Platform.setImplicitExit(false);
        setupMainWindowCloseListener(stage);
    }

    public abstract void onClose(WindowEvent e);

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

    /**
     * Adds a listener to the cross button in the upper right corner of the main window.
     * If the listener is triggered a yes or no dialog appear and asks the user if the
     * application should be terminated.
     *
     * @param stage The main stage.
     */
    private void setupMainWindowCloseListener(final Stage stage){
        stage.setOnCloseRequest(this::onClose);
    }
}