package com.udemy.cookbook.controllers;

import com.udemy.cookbook.services.IRecipeService;
import com.udemy.cookbook.services.RecipeServiceDBImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RecipeControllerTest {
    RecipeController recipeController;

    @Mock
    private IRecipeService recipeService;


    @Test
    public void getRecipes() throws Exception {

    }
}
