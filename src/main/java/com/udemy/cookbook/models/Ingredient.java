package com.udemy.cookbook.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Float amount;

    public Ingredient() { }

    public Ingredient(String name, Float amount) {
        super();
        this.name = name;
        this.amount = amount;
    }
}
