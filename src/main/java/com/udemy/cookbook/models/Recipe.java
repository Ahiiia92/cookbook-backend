package com.udemy.cookbook.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue
    private Integer recipeId;
    private String name, description, imagePath;

    // From Recipe to Comments : Recipe have many comments while this comment will have just one Recipe
    // Unique set of comments
    // with mappedBy = a property in comment will be called recipe
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Comment> comments;

    // A Recipe has many ingredients but ingredient also has many recipes
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_ingredient",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;

    // Enumtype.STRINg => So we can have additional level afterwards.
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    // We make the connextion with the join table called recipe_category
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rec_cat",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<FoodCategory> foodCategories;

    public Recipe() { }

    public Recipe(String name, String description, String imagePath) {
        super();
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Recipe(String name, String description, String imagePath, Set<Comment> comments, Set<Ingredient> ingredients, Difficulty difficulty, Set<FoodCategory> foodCategories) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.comments = comments;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.foodCategories = foodCategories;
    }

    public Integer getId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<FoodCategory> getFoodCategories() {
        return foodCategories;
    }

    public void setFoodCategories(Set<FoodCategory> foodCategories) {
        this.foodCategories = foodCategories;
    }
}
