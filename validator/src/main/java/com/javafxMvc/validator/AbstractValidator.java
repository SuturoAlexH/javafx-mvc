package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;

public abstract class AbstractValidator<T>  {

    ValidatableProperty<T> property;

    public AbstractValidator(final ValidatableProperty<T> property){
        this.property = property;
    }

    public boolean validate(){
        boolean isValid = evaluate();
        property.isVisibleProperty().set(!isValid);

        return isValid;
    }

    public abstract boolean evaluate();
}
