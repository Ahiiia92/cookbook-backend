package com.udemy.cookbook.seeds;

import com.github.javafaker.Faker;
import com.udemy.cookbook.models.Difficulty;
import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.repositories.RecipeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Seeds implements CommandLineRunner {
    private RecipeRepository recipeRepository;

    Faker faker = new Faker();

    public Seeds(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fodd categories:
        System.out.println("Creating some categories");
        Set<FoodCategory> catDessert = new HashSet<>();
        Set<FoodCategory> catExotic = new HashSet<>();
        FoodCategory d = new FoodCategory();
        d.setName("Dessert");
        FoodCategory e = new FoodCategory();
        e.setName("Exotic");
        FoodCategory f = new FoodCategory();
        f.setName("Fresh");
        catDessert.add(d);
        catExotic.add(e);
        catDessert.add(f);
        // Add: Save to FoodCategory Repository
        System.out.println("Food categories: done");

        // Ingredients
        System.out.println("Creating ingredients:");

        // Recipes
        System.out.println("Creating recipes:");
        Recipe tiramisu = new Recipe(
                "Tiramisù",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1542124948-dc391252a940?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=668&q=80"
        );
        tiramisu.setDifficulty(Difficulty.MODERATE);
//        tiramisu.setFoodCategories(catDessert);
        recipeRepository.save(tiramisu);

        Recipe bowl = new Recipe(
                "Bowl gourmand quinoa, courge rôtie, grenade et morceaux de Fol Epi",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1511378156040-1259b5bcd0fb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=627&q=80"
        );
        bowl.setDifficulty(Difficulty.EASY);
//        bowl.setFoodCategories(catExotic);
        recipeRepository.save(bowl);

        Recipe brownie = new Recipe(
                "Chocolate Brownie",
                StringUtils.abbreviate(faker.lorem().paragraph(), 250),
                "https://images.unsplash.com/photo-1590841609987-4ac211afdde1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80"
        );
        brownie.setDifficulty(Difficulty.EASY);
//        brownie.setFoodCategories(catDessert);
        recipeRepository.save(brownie);

        System.out.println("Recipes created...");
        System.out.println("Recipe 1: " + tiramisu.getName());
        System.out.println("Recipe 2: " + bowl.getName());
        System.out.println("Recipe 3: " + brownie.getName());
    }
}
