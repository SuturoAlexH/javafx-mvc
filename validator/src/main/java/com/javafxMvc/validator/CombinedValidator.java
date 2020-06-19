package com.javafxMvc.validator;

import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class combines multiple validators.
 */
public class CombinedValidator {

    private List<AbstractValidator> validatorList = new ArrayList<>();

    /**
     * Calls the validate method of all added validators and combines the results with ands.
     *
     * @return true if all validators return true and false otherwise
     */
    public boolean validate(){
        Boolean[] validArray = validatorList.stream().map(AbstractValidator::validate).toArray(Boolean[]::new);
        return BooleanUtils.and(validArray);
    }

    /**
     * Adds a validator to the validator list.
     *
     * @param validator the validator
     */
    public void addValidator(final AbstractValidator validator){
        validatorList.add(validator);
    }

    /**
     * Returns the list of all added validators.
     *
     * @return the validators
     */
    public List<AbstractValidator> getValidators(){
        return validatorList;
    }
}
