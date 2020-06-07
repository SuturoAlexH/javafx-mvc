package com.javafxMvc.test;

import com.javafxMvc.annotations.ValidationProperty;
import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.NotEmptyValidator;

public class TestModel {

    @ValidationProperty(validator = NotEmptyValidator.class, errorText="errorText1")
    private ValidatableProperty<String> property1;

    @ValidationProperty(validator = NotEmptyValidator.class, errorText="errorText2")
    private ValidatableProperty<String> property2;

    public ValidatableProperty<String> getProperty1() {
        return property1;
    }

    public ValidatableProperty<String> getProperty2() {
        return property2;
    }
}
