package com.javafxMvc.reflection;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.util.ReflectionUtil;

public class InjectReflectionLoader {

    public static void load(final MvcMap mvcMap){
        ReflectionUtil.iterateFields(mvcMap.getMvcClasses(), Inject.class, (clazz, field) -> {
            try {
                field.setAccessible(true);
                field.set(mvcMap.getMvcObjectByClass(clazz),mvcMap.getMvcObjectByClass(field.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
