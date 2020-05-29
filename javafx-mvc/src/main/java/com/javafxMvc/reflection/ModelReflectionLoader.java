package com.javafxMvc.reflection;

import com.javafxMvc.annotations.MVCModel;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import com.javafxMvc.reflection.mvcMap.NamedClass;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ModelReflectionLoader {

    public static void load(final String packagePath, final MvcMap mvcMap){
        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> modelClasses = reflections.getTypesAnnotatedWith(MVCModel.class);

        modelClasses.forEach(modelClass -> {
            try {
                Constructor<?> constructor = modelClass.getConstructor();
                Object model = constructor.newInstance();

                String name = StringUtils.substringBefore(modelClass.getSimpleName(), "Model");
                mvcMap.putModel(new NamedClass(name, modelClass), model);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
