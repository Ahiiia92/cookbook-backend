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
    private IRecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> getRecipes() { return recipeService.findAll(); }

    // Show a specific Recipe
    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.findById(id);
    }

    // TODO: Need to pass the test
    // Add a Recipe
    @PostMapping("/")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return recipeService.findById(recipe.getId());
    }

    // TODO: Need to pass the test
    // Edit a Recipe
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable Integer id, @RequestBody Recipe recipeDetails) {
        Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
        return ResponseEntity.ok().body(updatedRecipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeService.delete(id);
    }
}
