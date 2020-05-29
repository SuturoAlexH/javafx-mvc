package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;

public class DoubleValidator extends AbstractValidator<String> {

    public DoubleValidator(final ValidatableProperty<String> property, final String errorText) {
        super(property, errorText);
    }

    @Override
    public boolean evaluate() {
        return NumberUtil.isDouble(property.getValue());
    }

}
