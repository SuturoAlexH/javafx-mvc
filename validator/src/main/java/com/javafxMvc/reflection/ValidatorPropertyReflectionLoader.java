package com.javafxMvc.reflection;

import com.javafxMvc.annotations.ValidationProperty;
import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.AbstractValidator;
import com.javafxMvc.validator.CombinedValidator;
import com.util.reflection.ReflectionIterator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

class ValidatorPropertyReflectionLoader {

     static void load(final CombinedValidator combinedValidator, final Class validatableClass, final Map<Class, Object> mvcObjectsMap){
        ReflectionIterator.fields(validatableClass, ValidationProperty.class, (clazz, field) -> {
            try {
                //create validationProperty
                field.setAccessible(true);
                Constructor constructor = field.getType().getConstructor();
                Object validationProperty = constructor.newInstance();
                field.set(mvcObjectsMap.get(clazz), validationProperty);

                //create validator
                Class<? extends AbstractValidator> validatorClass = field.getAnnotation(ValidationProperty.class).validator();
                Constructor<? extends AbstractValidator> validatorConstructor = validatorClass.getConstructor(ValidatableProperty.class, String.class);
                String errorText = field.getAnnotation(ValidationProperty.class).errorText();
                AbstractValidator validator = validatorConstructor.newInstance(validationProperty, errorText);

                combinedValidator.addValidator(validator);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}
