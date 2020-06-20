package com.javafxMvc.reflection.method;

import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

/**
 * This loader class calls the annotated methods.
 */
public class MethodReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodReflectionLoader.class);

    /**
     * Calls the methods of the object provided by the mvc map that are annotated with #annotaion.
     *
     * @param mvcMap the mvc map
     * @param annotation the annotation
     */
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
