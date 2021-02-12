package com.udemy.cookbook.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Float amount;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes;

    public Ingredient() { }

    public Ingredient(String name, Float amount) {
        super();
        this.name = name;
        this.amount = amount;
    }
}
