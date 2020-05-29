package com.javafxMvc.validator;

import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.List;

public class CombinedValidator {

    private List<AbstractValidator> validatorList = new ArrayList<>();

    public boolean validate(){
        Boolean[] validArray = validatorList.stream().map(AbstractValidator::validate).toArray(Boolean[]::new);
        return BooleanUtils.and(validArray);
    }

    public void addValidator(final AbstractValidator validator){
        validatorList.add(validator);
    }
}
