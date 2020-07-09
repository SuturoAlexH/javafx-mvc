package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;
import com.javafxMvc.util.StringUtil;

/**
 * A validator class that validates if the input is a number.
 */
public class NumberValidator extends AbstractValidator<String> {

    /**
     * Constructs a number validator from a validatable property.
     *
     * @param property the validatable property
     */
    public NumberValidator(final ValidatableProperty<String> property) {
        super(property);
    }

    /**
     * Return true if the current value is a number.
     *
     * @return true if the current value is a number and false otherwise
     */
    @Override
    public boolean evaluate() {
        return StringUtil.isNullOrEmpty(property.getValue()) || NumberUtil.isInteger(property.getValue());
    }
}
