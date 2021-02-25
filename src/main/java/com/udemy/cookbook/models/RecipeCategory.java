package com.udemy.cookbook.models;

import javax.persistence.*;

/*
    Creation of a Join Table between Recipe and Food Category
    A Recipe can have many FoodCategories
    A FoodCategory can have many Recipes
*/

@Entity
@Table(name = "recipe_category")
public class RecipeCategory {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "recipe_id",
            referencedColumnName = "recipeId"
    )
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "categoryId"
    )
    private FoodCategory category;
}
