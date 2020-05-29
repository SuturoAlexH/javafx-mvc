package com.javafxMvc.reflection;

import com.javafxMvc.annotations.Validator;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import com.javafxMvc.validator.CombinedValidator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ValidatorReflectionLoader {
    public static void load(final MvcMap mvcMap){
        mvcMap.getControllerClasses().forEach(controllerClass ->
                Arrays.stream(controllerClass.getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(Validator.class))
                        .forEach(field -> {field.setAccessible(true);
                            try {
                                Constructor constructor = field.getType().getConstructor();
                                CombinedValidator combinedValidator = (CombinedValidator) constructor.newInstance();

                                field.set(mvcMap.getMvcObjectByClass(controllerClass), combinedValidator);
                                mvcMap.putCombinedValidator(field.getAnnotation(Validator.class).value(), combinedValidator);
                            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                                e.printStackTrace();
                            }
                        })
        );
    }
}
