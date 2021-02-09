package com.udemy.cookbook.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FoodCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

    public FoodCategory() {}

    public FoodCategory(String name, Set<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }
}
