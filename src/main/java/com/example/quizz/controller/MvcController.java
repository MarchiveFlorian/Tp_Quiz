package com.example.quizz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("compteur", countryService.compteur);
        return "quiz.html";
    }

    @PostMapping("reponse")
    public String postResponse(@RequestParam("capitale")String capital, Model model){

        Country countryReponse = countryService.getStoredCountry();
        Country randomCountry = countryService.getRandomCountry();
        countryService.validationReponse(capital, countryReponse);
        Integer x = countryService.getCompteur();
        model.addAttribute("pays", randomCountry);
        model.addAttribute("capitales", countryService.getRandomCapitals(randomCountry));
        model.addAttribute("compteur", x);

        System.out.println(capital);
        return "quiz.html";
    }



}
