package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InjectReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(InjectReflectionLoader.class);

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
