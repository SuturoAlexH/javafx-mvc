package com.javafxMvc.reflection;

import com.javafxMvc.annotations.MVCModel;
import com.javafxMvc.model.MvcMap;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ModelReflectionLoader {

    public static void load(final Reflections reflections, final MvcMap mvcMap){
        Set<Class<?>> modelClasses = reflections.getTypesAnnotatedWith(MVCModel.class);

        modelClasses.forEach(modelClass -> {
            try {
                Constructor<?> modelConstructor = modelClass.getConstructor();
                Object model = modelConstructor.newInstance();

                mvcMap.putModel(modelClass, model);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
