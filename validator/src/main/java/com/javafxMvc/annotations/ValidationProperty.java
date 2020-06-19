package com.javafxMvc.annotations;

import com.javafxMvc.validator.AbstractValidator;
import java.lang.annotation.*;

/**
 * This annotation is used to set an instance of the ValidatableProperty to the specified filed.
 * Also an instance of AbstractValidator is created and associated with the property.
 */
@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface ValidationProperty {
    Class<? extends AbstractValidator> value();
}
