package com.javafxMvc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to set an instance of the l10n to the specified filed.
 */
@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface InjectL10n {
}
