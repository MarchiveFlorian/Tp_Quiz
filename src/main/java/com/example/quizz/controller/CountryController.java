package com.example.quizz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizz.entity.Country;
import com.example.quizz.service.CountryService;

@RestController
@RequestMapping("api")
public class CountryController {

    // Injection
    @Autowired
    CountryService countryService;

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
  /*   @GetMapping("/random-item")
    public ResponseEntity<Item> getRandomItem() {
        Item randomItem = randomItemService.getRandomItem();
        return ResponseEntity.ok(randomItem);
    }*/
}