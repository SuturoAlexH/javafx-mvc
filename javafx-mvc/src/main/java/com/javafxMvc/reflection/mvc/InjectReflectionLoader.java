package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.model.MvcMap;
import com.util.reflection.ReflectionIterator;


public class InjectReflectionLoader {

    public static void load(final MvcMap mvcMap){
        ReflectionIterator.fields(mvcMap.getMvcMap().keySet(), Inject.class, (clazz, field) -> {
            try {
                field.setAccessible(true);
                field.set(mvcMap.getMvcObjectByClass(clazz),mvcMap.getMvcObjectByClass(field.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
