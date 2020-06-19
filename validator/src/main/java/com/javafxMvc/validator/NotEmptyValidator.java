package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;

/**
 *
 * @param <T>
 */
public class NotEmptyValidator<T> extends AbstractValidator<T> {

    /**
     *
     * @param property
     */
    public NotEmptyValidator(final ValidatableProperty<T> property) {
        super(property);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean evaluate() {
        if (property.getValue() instanceof String){
            String value = (String) property.getValue();
            return !value.isEmpty();
        }

        return property.getValue() != null;
    }
}
