package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.MVCModel;
import com.javafxMvc.model.MvcMap;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ModelReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelReflectionLoader.class);

    public static void load(final Reflections reflections, final MvcMap mvcMap){
        Set<Class<?>> modelClasses = reflections.getTypesAnnotatedWith(MVCModel.class);

        modelClasses.forEach(modelClass -> {
            try {
                Constructor modelConstructor = modelClass.getConstructor();
                Object model = modelConstructor.newInstance();

                mvcMap.putModel(modelClass, model);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}
