package com.n11.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CalculationForm {

    @NotNull
    private Integer integerInput;


    public Integer getIntegerInput() {
        return integerInput;
    }

    public void setIntegerInput(Integer integerInput) {
        this.integerInput = integerInput;
    }

}
