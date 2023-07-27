package com.example.quizz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

    // attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String capital;
    private String name;

    // contructeurs
    public Country() {
    }

    public Country(int id, String capital, String name) {
        this.id = id;
        this.capital = capital;
        this.name = name;
    }

    // getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // to string
    @Override
    public String toString() {
        return "Country [id=" + id + ", capital=" + capital + ", name=" + name + "]";
    }
}
