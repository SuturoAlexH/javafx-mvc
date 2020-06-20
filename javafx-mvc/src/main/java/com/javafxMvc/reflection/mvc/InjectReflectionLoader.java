package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This loader class sets the instances to all fields annotated with inject.
 */
public class InjectReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(InjectReflectionLoader.class);

    /**
     * Sets the instance provided by the mvcMap the all fields annotated with inject.
     *
     * @param mvcMap the mvcMap
     */
    public static void load(final MvcMap mvcMap){
        ReflectionIterator.fields(mvcMap.getMvcMap().keySet(), Inject.class, (clazz, field) -> {
            try {
                field.setAccessible(true);
                field.set(mvcMap.getMvcObjectByClass(clazz),mvcMap.getMvcObjectByClass(field.getType()));
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}
