package com.javafxMvc.test;

import com.javafxMvc.annotations.Validator;
import com.javafxMvc.validator.CombinedValidator;

public class TestController {

    @Validator(TestModel.class)
    private CombinedValidator combinedValidator;

    public CombinedValidator getCombinedValidator() {
        return combinedValidator;
    }
}
