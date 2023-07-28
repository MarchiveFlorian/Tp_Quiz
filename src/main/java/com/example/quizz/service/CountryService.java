package com.example.quizz.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizz.dao.CountryRepository;
import com.example.quizz.entity.Country;

@Service
public class CountryService {

    // inject repo
    @Autowired
    CountryRepository countryRepository;

    Random random = new Random();
    public Integer compteur = 0;
    Country randomCountry;
    

    // get all
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // get one
    public Optional<Country> getOneCountry(Integer id) {
        return countryRepository.findById(id);
    }

    //Get random country
    public Country getRandomCountry(){
        List<Country> allCountries = countryRepository.findAll();
        int randomIndex = random.nextInt(allCountries.size());
        randomCountry = allCountries.get(randomIndex);  
        return randomCountry;
    }

    //Get random country stored
    public Country getStoredCountry(){
        return randomCountry;
    }

    //Get random capitals
    public List<String> getRandomCapitals(Country randomCountry){

        List<Country> allCountries = countryRepository.findAll();

        //on recup sa capitale
        String countryCapital = randomCountry.getCapital();

        //On enleve de la liste l'index du pays sélectionné
        allCountries.remove(randomCountry);

        //recupere 3 random capitales
        List<String> allCapitals = allCountries.stream().map(Country::getCapital).collect(Collectors.toList());
        Collections.shuffle(allCapitals);
        List<String> randomCapitals = allCapitals.subList(0, 3);

        //Ajouter la capitale du pays séléctionné à la liste des capitales aléatoires
        randomCapitals.add(countryCapital);

        // Mélanger la liste de toutes les capitales pour rendre l'ordre aléatoire
        Collections.shuffle(randomCapitals);

        System.out.println(randomCountry.getName() + " " + randomCountry.getCapital());
        return randomCapitals;
    }

    public Boolean validationReponse(String capital, Country randomCountry){
        if(randomCountry.getCapital().equals(capital)){
            compteur++;
        }
        else{
            compteur--;
        }
        return randomCountry.getCapital().equals(capital);
    }

    public Integer getCompteur(){
        return compteur;
    }
} 