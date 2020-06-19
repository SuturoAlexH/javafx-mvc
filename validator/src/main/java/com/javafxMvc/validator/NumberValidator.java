package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.util.NumberUtil;
import com.javafxMvc.util.StringUtil;

/**
 * 
 */
public class NumberValidator extends AbstractValidator<String> {

    /**
     *
     * @param property
     */
    public NumberValidator(final ValidatableProperty<String> property) {
        super(property);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean evaluate() {//TODO: number should not be empty
        return StringUtil.isNullOrEmpty(property.getValue()) || NumberUtil.isInteger(property.getValue());
    }
}
