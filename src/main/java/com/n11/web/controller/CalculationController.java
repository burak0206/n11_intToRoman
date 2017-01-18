package com.n11.web.controller;

import com.google.gson.JsonObject;
import com.n11.service.CalculationService;
import com.n11.web.model.CalculationForm;
import com.n11.web.validation.IntegerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by burakdagli on 16.01.2017.
 */
@Controller
@RequestMapping("/api")
public class CalculationController {

    @Autowired
    IntegerValidator integerValidator;

    @Autowired
    CalculationService calculationService;

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    @ResponseBody
    public String postConvert(CalculationForm calculationForm, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        JsonObject status = new JsonObject();

        integerValidator.validate(calculationForm, bindingResult);

        if (bindingResult.hasErrors() ) {
            if (bindingResult.hasFieldErrors("integerInput")) {
                status.addProperty("errorMessage", "Bir tam sayi giriniz.");
            }
            return status.toString();
        }

        String result = calculationService.intToRoman(calculationForm.getIntegerInput());

        response.setContentType("application/json");
        status.addProperty("result", result);
        return status.toString();
    }

}
