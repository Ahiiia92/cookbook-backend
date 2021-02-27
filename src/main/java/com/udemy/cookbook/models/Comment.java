package com.udemy.cookbook.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    // Comment goes back to Recipe.
    @JsonBackReference
    @ManyToOne
    private Recipe recipe;

    public Comment() {};

    public Comment(String content, Recipe recipe) {
        this.content = content;
        this.recipe = recipe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
