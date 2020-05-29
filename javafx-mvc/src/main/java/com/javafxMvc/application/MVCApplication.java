package com.javafxMvc.application;

import com.javafxMvc.reflection.*;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import javafx.application.Application;
import javafx.stage.Stage;
import com.javafxMvc.annotations.*;

public abstract class MVCApplication extends Application {

   protected MvcMap mvcMap = new MvcMap();

    @Override
    public void start(Stage stage){
        initializeMvc();
        initialize(stage);
    }

    public abstract void initialize(Stage stage);

    private void initializeMvc(){
       String packagePath = "org.openjfx";

       ModelReflectionLoader.load(packagePath, mvcMap);
       ViewReflectionLoader.load(packagePath, mvcMap);
       ControllerReflectionLoader.load(packagePath, mvcMap);
       ValidatorReflectionLoader.load(mvcMap);
       ValidatorPropertyReflectionLoader.load(packagePath, mvcMap);

       InjectReflectionLoader.load(mvcMap);

       MethodReflectionLoader.load(mvcMap, Bind.class);
       MethodReflectionLoader.load(mvcMap, PostConstruct.class);
    }
}