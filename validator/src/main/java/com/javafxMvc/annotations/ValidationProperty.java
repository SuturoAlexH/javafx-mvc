package com.javafxMvc.annotations;

import com.javafxMvc.validator.AbstractValidator;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface ValidationProperty {
    Class<? extends AbstractValidator> validator();

    String errorText();
}
