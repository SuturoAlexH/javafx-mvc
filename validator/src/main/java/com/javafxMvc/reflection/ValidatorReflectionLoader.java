package com.javafxMvc.reflection;

import com.javafxMvc.annotations.Validator;
import com.javafxMvc.validator.CombinedValidator;
import com.util.reflection.ReflectionIterator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ValidatorReflectionLoader {
    public static void load(final Map<Class, Object> mvcObjectsMap){
        ReflectionIterator.fields(mvcObjectsMap.keySet(), Validator.class, (clazz, field) -> {
            try {
                Constructor validatorConstructor = field.getType().getConstructor();
                CombinedValidator combinedValidator = (CombinedValidator) validatorConstructor.newInstance();

                field.setAccessible(true);
                field.set(mvcObjectsMap.get(clazz), combinedValidator);

                ValidatorPropertyReflectionLoader.load(combinedValidator, field.getAnnotation(Validator.class).value(), mvcObjectsMap);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}
