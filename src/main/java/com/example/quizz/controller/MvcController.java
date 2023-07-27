package com.example.quizz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.quizz.service.CountryService;

@Controller
public class MvcController {
    
    @Autowired
    CountryService countryService;
}
