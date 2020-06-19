package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;

/**
 * A base class for all validators.
 *
 * @param <T> the type of the value that is evaluated
 */
public abstract class AbstractValidator<T>  {

    ValidatableProperty<T> property;

    AbstractValidator(final ValidatableProperty<T> property){
        this.property = property;
    }

    /**
     * Returns true if the current value is valid and false otherwise.
     * Also the visible property is set corresponding to the valid state.
     *
     * @return true if the current value is valid and false otherwise.
     */
    public boolean validate(){
        boolean isValid = evaluate();
        property.isVisibleProperty().set(!isValid);

        return isValid;
    }

    /**
     * Returns true if the current value is valid and false otherwise.
     *
     * @return true if the current value is valid and false otherwise.
     */
    public abstract boolean evaluate();
}
