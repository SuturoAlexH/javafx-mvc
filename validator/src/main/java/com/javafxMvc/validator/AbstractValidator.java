package com.javafxMvc.validator;

import com.javafxMvc.model.ValidatableProperty;

public abstract class AbstractValidator<T>  {

    ValidatableProperty<T> property;

    private String errorText;

    public AbstractValidator(final ValidatableProperty<T> property, final String errorText){
        this.property = property;
        this.errorText = errorText;
    }

    public boolean validate(){
        boolean isValid = evaluate();
        if(isValid){
            property.isVisibleProperty().set(false);
        }else {
            property.isVisibleProperty().set(true);
            property.errorProperty().set(errorText);
        }

        return isValid;
    }

    public abstract boolean evaluate();
}
