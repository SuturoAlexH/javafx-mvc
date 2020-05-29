package com.javafxMvc.reflection;

import com.javafxMvc.reflection.mvcMap.MvcMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MethodReflectionLoader {

    public static void load(final MvcMap mvcMap, final Class<? extends Annotation> annotationClass){
        mvcMap.getControllerClasses().forEach(controllerClass ->
                Arrays.stream(controllerClass.getDeclaredMethods())
                        .filter(method -> method.isAnnotationPresent(annotationClass))
                        .forEach(method -> {method.setAccessible(true);
                            try {
                                method.invoke(mvcMap.getMvcObjectByClass(controllerClass));
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        })
        );
    }
}
