package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;

public class NumberValidator extends AbstractValidator<String> {

    public NumberValidator(final ValidatableProperty<String> property, final String errorText) {
        super(property, errorText);
    }

    @Override
    public boolean evaluate() {
        return NumberUtil.isInteger(property.getValue());
    }
}
