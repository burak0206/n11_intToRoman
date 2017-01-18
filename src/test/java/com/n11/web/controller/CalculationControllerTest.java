package com.n11.web.controller;

import com.n11.service.CalculationService;
import com.n11.web.model.CalculationForm;
import com.n11.web.validation.IntegerValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by burakdagli on 18.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculationControllerTest {
    private MockHttpServletResponse response = new MockHttpServletResponse();
    private MockHttpServletRequest request = new MockHttpServletRequest();

    @InjectMocks
    private CalculationController calculationController;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private IntegerValidator integerValidator;

    @Mock
    private CalculationService calculationService;

    @Test
    public void shouldReturnSuccessWhenIntegerWasEntered(){
        CalculationForm calculationForm = new CalculationForm();

        when(bindingResult.hasErrors()).thenReturn(false);
        when(bindingResult.hasFieldErrors("integerInput")).thenReturn(false);
        when(calculationService.intToRoman(calculationForm.getIntegerInput())).thenReturn("M");

        String result = calculationController.postConvert(calculationForm, bindingResult, request, response);
        assertThat(result, equalTo("{\"result\":\"M\"}"));
    }

    @Test
    public void shouldReturnFalseWhenStringOrEmptyWasEntered(){
        CalculationForm calculationForm = new CalculationForm();

        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.hasFieldErrors("integerInput")).thenReturn(true);

        String result = calculationController.postConvert(calculationForm, bindingResult, request, response);
        assertThat(result, equalTo("{\"errorMessage\":\"Bir tam sayi giriniz.\"}"));
    }

    @Test
    public void shouldReturnFalseWhenThereIsNoIntegerInputError(){
        CalculationForm calculationForm = new CalculationForm();

        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.hasFieldErrors("integerInput")).thenReturn(false);

        String result = calculationController.postConvert(calculationForm, bindingResult, request, response);
        assertThat(result, equalTo("{}"));
    }

}