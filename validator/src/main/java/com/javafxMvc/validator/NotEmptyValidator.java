package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.StringUtil;

/**
 * A validator class that validates if the input is a empty or null.
 *
 * @param <T> the type of the value that is evaluated
 */
public class NotEmptyValidator<T> extends AbstractValidator<T> {

    /**
     * Constructs a not empty validator from a validatable property.
     *
     * @param property the validatable property
     */
    public NotEmptyValidator(final ValidatableProperty<T> property) {
        super(property);
    }

    /**
     * Return true if the input is null. If the value is a string its also checked if the value is empty.
     *
     * @return true if the value is null or empty or false otherwise
     */
    @Override
    public boolean evaluate() {
        if (property.getValue() instanceof String){
            String value = (String) property.getValue();
            return !StringUtil.isNullOrEmpty(value);
        }

        return property.getValue() != null;
    }
}
