package com.n11.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by burakdagli on 18.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceTest {

    @InjectMocks
    CalculationService calculationService;

    @Test
    public void shouldReturnXIV(){
        String result = calculationService.toRoman(14);
        assertEquals(result, "XIV");
    }

    @Test
    public void shouldReturnXXIV(){
        String result = calculationService.toRoman(24);
        assertEquals(result, "XXIV");
    }


    @Test
    public void shouldReturnXXXII(){
        String result = calculationService.toRoman(32);
        assertEquals(result, "XXXII");
    }


    @Test
    public void shouldReturnXLVIII(){
        String result = calculationService.toRoman(48);
        assertEquals(result, "XLVIII");
    }


    @Test
    public void shouldReturnLX(){
        String result = calculationService.toRoman(60);
        assertEquals(result, "LX");
    }


    @Test
    public void shouldReturnLXVIII(){
        String result = calculationService.toRoman(68);
        assertEquals(result, "LXVIII");
    }


    @Test
    public void shouldReturnXCVI(){
        String result = calculationService.toRoman(96);
        assertEquals(result, "XCVI");
    }

    @Test
    public void shouldReturnCLIX(){
        String result = calculationService.toRoman(159);
        assertEquals(result, "CLIX");
    }

    @Test
    public void shouldReturnCCXVII(){
        String result = calculationService.toRoman(217);
        assertEquals(result, "CCXVII");
    }

    @Test
    public void shouldReturnDCCXCIII(){
        String result = calculationService.toRoman(793);
        assertEquals(result, "DCCXCIII");
    }

    @Test
    public void shouldReturnMMMMCDXXXII(){
        String result = calculationService.toRoman(4432);
        assertEquals(result, "MMMMCDXXXII");
    }


}