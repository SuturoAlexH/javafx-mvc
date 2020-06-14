package com.javafxMvc.test;

import com.javafxMvc.annotations.ValidationProperty;
import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.NotEmptyValidator;

public class TestModel {

    @ValidationProperty(NotEmptyValidator.class)
    private ValidatableProperty<String> property1;

    @ValidationProperty(NotEmptyValidator.class)
    private ValidatableProperty<String> property2;

    public ValidatableProperty<String> getProperty1() {
        return property1;
    }

    public ValidatableProperty<String> getProperty2() {
        return property2;
    }
}
