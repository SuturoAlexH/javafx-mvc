package com.javafxMvc.reflection;

import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.util.ReflectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class MethodReflectionLoader {

    public static void load(final MvcMap mvcMap, final Class<? extends Annotation> annotation){
        ReflectionUtil.iterateMethods(mvcMap.getControllerClasses(), annotation, (clazz, method) -> {
            try {
                method.setAccessible(true);
                method.invoke(mvcMap.getMvcObjectByClass(clazz));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
