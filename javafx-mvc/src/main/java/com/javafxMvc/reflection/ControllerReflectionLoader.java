package com.javafxMvc.reflection;

import com.javafxMvc.annotations.MVCController;
import com.javafxMvc.dialog.DialogController;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import com.javafxMvc.reflection.mvcMap.NamedClass;
import javafx.scene.Parent;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ControllerReflectionLoader {

    public static void load(final String packagePath, final MvcMap mvcMap){
        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> controllerClasses = reflections.getTypesAnnotatedWith(MVCController.class);

        controllerClasses.forEach(controllerClass -> {
            try {
                Object controller;
                String name = StringUtils.substringBefore(controllerClass.getSimpleName(), "Controller");
                if(controllerClass.getSuperclass().equals(DialogController.class)){
                    Constructor<?> cons = controllerClass.getConstructor(Parent.class);
                    controller = cons.newInstance(mvcMap.getNodeByName(name));
                }else{
                    Constructor<?> cons = controllerClass.getConstructor();
                    controller = cons.newInstance();
                }

                mvcMap.putController(new NamedClass(name, controllerClass), controller);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}