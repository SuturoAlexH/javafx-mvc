package com.javafxMvc.reflection.method;

import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class MethodReflectionLoader {

    public static void load(final MvcMap mvcMap, final Class<? extends Annotation> annotation){
        ReflectionIterator.methods(mvcMap.getControllerClasses(), annotation, (clazz, method) -> {
            try {
                method.setAccessible(true);
                method.invoke(mvcMap.getMvcObjectByClass(clazz));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
