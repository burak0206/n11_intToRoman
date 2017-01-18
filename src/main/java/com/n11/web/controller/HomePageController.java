package com.n11.web.controller;

import com.n11.web.model.CalculationForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
@RequestMapping("/")
public class HomePageController{

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }



}
