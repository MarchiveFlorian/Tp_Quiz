package com.example.quizz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizz.dao.CountryRepository;
import com.example.quizz.entity.Country;
import com.example.quizz.service.CountryService;

@RestController
@RequestMapping("api")
public class CountryController {

    // Injection
    @Autowired
    CountryService countryService;

    @Autowired
    CountryRepository countryRepository;

    // Méthode GET ALL
    @GetMapping("countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // Méthode GET ONE
    @GetMapping("countries/{id}")
    public ResponseEntity<Country> getOneCountry(@PathVariable("id") Integer id) {
        Optional<Country> optional = countryService.getOneCountry(id);

        if (optional.isPresent()) {
            Country country = optional.get();
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // On créer la question
    @GetMapping("/quiz")
    public List<String> getQuiz() {

        Country randomCountry = countryService.getRandomCountry();
        List<String> randomCapitals = countryService.getRandomCapitals(randomCountry);
        return randomCapitals;
    }
}