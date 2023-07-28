package com.example.quizz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.quizz.entity.Country;
import com.example.quizz.service.CountryService;

@Controller
public class MvcController {
    
    @Autowired
    CountryService countryService;

    @GetMapping("quiz")
    public String quiz(Model model){
        Country randomCountry = countryService.getRandomCountry();
        model.addAttribute("pays", randomCountry);
        model.addAttribute("capitales", countryService.getRandomCapitals(randomCountry));
        return "quiz.html";
    }




}
