package com.udemy.cookbook.services;

import com.udemy.cookbook.exceptions.RecipeNotFoundException;
import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("RecipeServiceDBImpl")
public class RecipeServiceDBImpl implements IRecipeService {
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Integer i) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(i);
        // Optional to handle to handle null references / NullPointerException
        if(optionalRecipe.isPresent())
            return optionalRecipe.get();
        else
            throw  new RecipeNotFoundException(i);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Integer id) {
        try {
            recipeRepository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe recipeDetails) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if(optionalRecipe.isPresent()) {
            optionalRecipe.get().setName(recipeDetails.getName());
            optionalRecipe.get().setFoodCategories(recipeDetails.getFoodCategories());
            optionalRecipe.get().setDifficulty(recipeDetails.getDifficulty());
            optionalRecipe.get().setComments(recipeDetails.getComments());
            optionalRecipe.get().setDescription(recipeDetails.getDescription());
            optionalRecipe.get().setImagePath(recipeDetails.getImagePath());
            optionalRecipe.get().setIngredients(recipeDetails.getIngredients());
            recipeRepository.save(optionalRecipe.get());
            return optionalRecipe.get();
        } else {
            throw new RecipeNotFoundException(id);
        }
    }

}
