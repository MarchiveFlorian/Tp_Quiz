package com.example.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizz.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
