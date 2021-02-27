package com.udemy.cookbook.seeds;

import com.github.javafaker.Faker;
import com.udemy.cookbook.models.Difficulty;
import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.models.Ingredient;
import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.repositories.FoodCategoryRepository;
import com.udemy.cookbook.repositories.IngredientRepository;
import com.udemy.cookbook.repositories.RecipeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Seeds implements CommandLineRunner {
    private RecipeRepository recipeRepository;
    private FoodCategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;

    Faker faker = new Faker();

    public Seeds(RecipeRepository recipeRepository,
                 FoodCategoryRepository categoryRepository,
                 IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fodd categories:
        System.out.println("Creating some categories");
        Set<FoodCategory> catDessert = new HashSet<>();
        Set<FoodCategory> catExotic = new HashSet<>();
        FoodCategory d = new FoodCategory();
        d.setName("Sweet");
        categoryRepository.save(d);
        System.out.println("Category " + d.getName() + " created");
        FoodCategory e = new FoodCategory();
        e.setName("Fruity");
        categoryRepository.save(e);
        System.out.println("Category " + e.getName() + " created");
        FoodCategory f = new FoodCategory();
        f.setName("Fresh");
        categoryRepository.save(f);
        System.out.println("Category " + f.getName() + " created");

        // Set of Dessert categories:
        catDessert.add(d);
        catDessert.add(f);
        System.out.println("Dessert Category is composed of:" + catDessert);
        // Set of Exotic categories:
        catExotic.add(e);
//        catExotic.add(d);
        System.out.println("Dessert Exotic is composed of:" + catExotic);

        System.out.println("Food categories: done");

        // Ingredients
        System.out.println("Creating ingredients...");
        Ingredient i1 = new Ingredient("Mascarpone", (float) 1.5);
        Ingredient i2 = new Ingredient("Chocolate", (float) 2);
        Ingredient i3 = new Ingredient("Potatoes", (float) 5);
        Ingredient i4 = new Ingredient("Tomatoes", (float) 2);
        Ingredient i5 = new Ingredient("Eggs", (float) 4);
        Ingredient i6 = new Ingredient("Nuts", (float) 3.5);
        ingredientRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6));
        System.out.println("Ingredients: done");

        // Recipes
        System.out.println("Creating recipes:");
        Recipe tiramisu = new Recipe(
                "Tiramisù",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1542124948-dc391252a940?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=668&q=80"
        );
        tiramisu.setDifficulty(Difficulty.MODERATE);
        tiramisu.setFoodCategories(catDessert);
        recipeRepository.save(tiramisu);
        System.out.println("Allocating Ingredients to " + tiramisu.getName());
        // Add ingredients to the Hashset using add method
        tiramisu.getIngredients().addAll(Arrays.asList(i1, i2));
        i1.getRecipes().add(tiramisu);
        i2.getRecipes().add(tiramisu);
        // Add ingredients through setters
        //  tiramisu.setIngredients(new HashSet<>(Arrays.asList(i1, i2)));
        recipeRepository.save(tiramisu);
        ingredientRepository.saveAll(Arrays.asList(i1, i2));
        //   ingredientRepository.saveAll(Arrays.asList(i1, i2));
        System.out.println("ingredients added to " + tiramisu.getName() + ": " + tiramisu.getIngredients() + ", and i1.getRecipes(): " + i1.getRecipes());

        Recipe bowl = new Recipe(
                "Bowl gourmand quinoa, courge rôtie, grenade et morceaux de Fol Epi",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1511378156040-1259b5bcd0fb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=627&q=80"
        );
        bowl.setDifficulty(Difficulty.EASY);
        bowl.setFoodCategories(catExotic);
        System.out.println("Allocating Ingredients to " + bowl.getName());
        // Add ingredients through setters
//        bowl.setIngredients(new HashSet<>(Arrays.asList(i3, i4)));
        // Add ingredients to the Hashset using add method
        bowl.getIngredients().addAll(Arrays.asList(i3, i4));
        i4.getRecipes().add(bowl);
        i3.getRecipes().add(bowl);
        recipeRepository.save(bowl);
        ingredientRepository.saveAll(Arrays.asList(i3, i4));
        System.out.println("ingredients added to " + bowl.getName() + ": " + bowl.getIngredients());

        Recipe brownie = new Recipe(
                "Chocolate Brownie",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1590841609987-4ac211afdde1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80"
        );
        brownie.setDifficulty(Difficulty.EASY);
        //  brownie.setFoodCategories(catDessert);
        System.out.println("Allocating Ingredients to " + brownie.getName());
        // Add ingredients through setters
        //  brownie.setIngredients(new HashSet<>(Collections.singletonList(i2)));
        // Add ingredients to the Hashset using add method
        brownie.getIngredients().add(i2);
        i2.getRecipes().add(brownie);
        recipeRepository.save(brownie);

        System.out.println("Recipes created...");
        System.out.println("Recipe 1: " + tiramisu.getName());
        System.out.println("Recipe 2: " + bowl.getName());
        System.out.println("Recipe 3: " + brownie.getName());
    }
}
