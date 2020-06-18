package com.javafxMvc.reflection.method;

import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class MethodReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodReflectionLoader.class);

    public static void load(final MvcMap mvcMap, final Class<? extends Annotation> annotation){
        ReflectionIterator.methods(mvcMap.getControllerClasses(), annotation, (clazz, method) -> {
            try {
                method.setAccessible(true);
                method.invoke(mvcMap.getMvcObjectByClass(clazz));
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}
