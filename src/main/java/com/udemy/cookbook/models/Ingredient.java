package com.udemy.cookbook.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Float amount;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredients")
    private Set<Recipe> recipes = new HashSet<>();

    public Ingredient() { }

    public Ingredient(String name, Float amount) {
        super();
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
