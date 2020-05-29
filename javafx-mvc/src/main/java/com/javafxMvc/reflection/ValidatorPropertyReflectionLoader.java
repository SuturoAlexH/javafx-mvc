package com.javafxMvc.reflection;

import com.javafxMvc.annotations.ValidationProperty;
import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import com.javafxMvc.validator.AbstractValidator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ValidatorPropertyReflectionLoader {

    public static void load(final String packagePath, final MvcMap mvcMap){
        mvcMap.getModelClasses().forEach(modelClass ->
                Arrays.stream(modelClass.getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(ValidationProperty.class))
                        .forEach(field -> {
                            try {
                                field.setAccessible(true);
                                Constructor constructor = field.getType().getConstructor();
                                Object validationProperty = constructor.newInstance();
                                field.set(mvcMap.getMvcObjectByClass(modelClass), validationProperty);

                                Class<? extends AbstractValidator> validatorClass = field.getAnnotation(ValidationProperty.class).validator();
                                Constructor<? extends AbstractValidator> validatorConstructor = validatorClass.getConstructor(ValidatableProperty.class, String.class);
                                String errorText = field.getAnnotation(ValidationProperty.class).errorText();
                                AbstractValidator validator = validatorConstructor.newInstance(validationProperty, errorText);

                                mvcMap.getCombinedValidator(modelClass).addValidator(validator);
                            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                                e.printStackTrace();
                            }
                        })
        );
    }
}
