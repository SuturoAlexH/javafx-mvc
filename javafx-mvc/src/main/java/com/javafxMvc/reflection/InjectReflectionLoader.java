package com.javafxMvc.reflection;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.reflection.mvcMap.MvcMap;

import java.util.Arrays;

public class InjectReflectionLoader {

    public static void load(final MvcMap mvcMap){
        mvcMap.getMvcClasses().forEach(clazz ->
                Arrays.stream(clazz.getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(Inject.class))
                        .forEach(field -> {
                            try {
                                field.setAccessible(true);
                                field.set(mvcMap.getMvcObjectByClass(clazz),mvcMap.getMvcObjectByClass(field.getType()));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }})
        );
    }
}
