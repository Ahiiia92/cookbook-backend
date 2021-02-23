package com.udemy.cookbook.services;

import com.udemy.cookbook.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRecipeService {
    List<Recipe> findAll();

    Recipe findById(Integer id);

    Recipe save(Recipe recipe);

    void delete(Integer id);

    Recipe updateRecipe(Integer id, Recipe recipeDetails);
}
