package com.example.quizz.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizz.dao.CountryRepository;
import com.example.quizz.entity.Country;

@Service
public class CountryService {

    // inject repo
    @Autowired
    CountryRepository countryRepository;

    Random random;

    // get all
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // get one
    public Optional<Country> getOneCountry(Integer id) {
        return countryRepository.findById(id);
    }

    // get randomCountry
    public Country getOneRandomCountry(){
        List<Country> allCountries = countryRepository.findAll();
        int randomIndex = random.nextInt(allCountries.size());
        return allCountries.get(randomIndex);
    }
}
