package com.n11.web.validation;

import com.n11.web.model.CalculationForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by burakdagli on 18.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegerValidatorTest {

    @InjectMocks
    IntegerValidator validator;

    @Mock
    private BindingResult bindingResult;

    @Test
    public void shouldNotBeValidWhenIntegerIsNull(){
        CalculationForm calculationForm = new CalculationForm();

        validator.validate(calculationForm, bindingResult);
        verify(bindingResult).rejectValue("integerInput", "error.integer",null,"Bir tam sayi giriniz.");
    }

    @Test
    public void shouldBeValidWhenIntegerIsNotNull(){
        CalculationForm calculationForm = new CalculationForm();
        calculationForm.setIntegerInput(123);

        validator.validate(calculationForm, bindingResult);
        assertFalse(bindingResult.hasErrors());
    }

}