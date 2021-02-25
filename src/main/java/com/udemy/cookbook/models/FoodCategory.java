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
    private Integer categoryId;
    private String name;

//    @ManyToMany(mappedBy = "foodCategories", cascade = CascadeType.MERGE)
//    private Set<Recipe> recipes;

    public FoodCategory() {}

    public FoodCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Set<Recipe> recipes) {
//        this.recipes = recipes;
//    }

    public Integer getId() {
        return categoryId;
    }
}
