package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;

public class DoubleValidator extends AbstractValidator<String> {

    public DoubleValidator(ValidatableProperty<String> property) {
        super(property);
    }

    @Override
    public boolean evaluate() {
        return NumberUtil.isDouble(property.getValue());
    }

}
