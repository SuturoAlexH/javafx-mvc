package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.StringUtil;

public class NotEmptyValidator<T> extends AbstractValidator<T> {
    public NotEmptyValidator(final ValidatableProperty<T> property, final String errorText) {
        super(property, errorText);
    }

    @Override
    public boolean evaluate() {
        if (property.getValue() instanceof String){
            String value = (String) property.getValue();
            return !StringUtil.isEmpty(value);
        }

        return property.getValue() != null;
    }
}
