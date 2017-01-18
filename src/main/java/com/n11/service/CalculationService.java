package com.n11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by burakdagli on 17.01.2017.
 */
@Service
public class CalculationService {

    public final int[] NUMBER_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    public final String[] NUMBER_LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String toRoman(int num) {
        String roman = "";
        for (int i = 0; i < NUMBER_VALUES.length; i++) {
            while (num >= NUMBER_VALUES[i]) {
                roman += NUMBER_LETTERS[i];
                num -= NUMBER_VALUES[i];
            }
        }
        return roman;
    }

    public String intToRoman(Integer integerInput) {
        return toRoman(integerInput);
    }
}
