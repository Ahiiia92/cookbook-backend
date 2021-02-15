package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RecipeController {
    @Autowired
    IRecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> getRecipes() { return recipeService.findAll(); }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.findById(id);
    }

    // TODO: Need to pass the test
    @PostMapping("/")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return recipeService.findById(recipe.getId());
    }

    // TODO: Need to pass the test
    @PutMapping("/recipes/{id}")
    public Recipe editRecipe(@RequestParam("recipe_id") Integer id, @RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return recipeService.findById(id);
    }

    // TODO: Need to pass the test
    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@RequestParam("recipe_id") Integer id) {
        recipeService.delete(id);
    }
}
