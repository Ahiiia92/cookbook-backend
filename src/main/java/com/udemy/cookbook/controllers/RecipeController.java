package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class RecipeController {
    @Autowired
    IRecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> getRecipes() { return recipeService.findAll(); }
}
