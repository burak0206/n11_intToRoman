package com.n11.web.validation;

import com.n11.web.model.CalculationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by burakdagli on 18.01.2017.
 */

@Component
public class IntegerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {

        return CalculationForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "integerInput", "error.integer", "Bir tam sayi giriniz.");
    }
}
