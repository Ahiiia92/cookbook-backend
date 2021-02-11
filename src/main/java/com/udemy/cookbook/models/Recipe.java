package com.udemy.cookbook.models;

import javax.persistence.*;


@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name, description, imagePath;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Recipe() { }

    public Recipe(String name, String description, String imagePath) {
        super();
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Recipe(String name, String description, String imagePath, FoodCategory foodCategory) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.foodCategory = foodCategory;
    }

    public Recipe(String name, String description, String imagePath, Ingredient ingredient) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.ingredient = ingredient;
    }

    public Integer getId() {
        return id;
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

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
}
