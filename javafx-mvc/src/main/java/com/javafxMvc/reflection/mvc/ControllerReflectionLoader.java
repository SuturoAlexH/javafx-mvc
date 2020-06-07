package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.MVCController;
import com.javafxMvc.model.MvcMap;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ControllerReflectionLoader {

    public static void load(final Reflections reflections, final MvcMap mvcMap){
        Set<Class<?>> controllerClasses = reflections.getTypesAnnotatedWith(MVCController.class);

        controllerClasses.forEach(controllerClass -> {
            try {
                Constructor controllerConstructor = controllerClass.getConstructor();
                Object controller = controllerConstructor.newInstance();

                mvcMap.putController(controllerClass, controller);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}