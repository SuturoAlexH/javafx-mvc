package com.javafxMvc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to set an instance of CombinedValidator to the specified filed.
 * The validator is associated with the class specified thou the value.
 */
@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface Validator {
    Class value();
}
