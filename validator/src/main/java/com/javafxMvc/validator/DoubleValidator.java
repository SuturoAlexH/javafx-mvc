package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;

/**
 * A validator class that validates if the input is a double.
 */
public class DoubleValidator extends AbstractValidator<String> {

    /**
     * Constructs a double validator from a validatable property.
     *
     * @param property the validatable property
     */
    public DoubleValidator(ValidatableProperty<String> property) {
        super(property);
    }

    /**
     * Return true if the current value is a double.
     *
     * @return true if the current value is a double and false otherwise
     */
    @Override
    public boolean evaluate() {
        return NumberUtil.isDouble(property.getValue());
    }

}
