package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;
import com.javafxMvc.util.StringUtil;

public class NumberValidator extends AbstractValidator<String> {

    public NumberValidator(final ValidatableProperty<String> property) {
        super(property);
    }

    @Override
    public boolean evaluate() {
        return StringUtil.isNullOrEmpty(property.getValue()) || NumberUtil.isInteger(property.getValue());
    }
}
