package com.udemy.cookbook.services;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecipeServiceDBImplTest {
    @InjectMocks
    private RecipeServiceDBImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;


    @BeforeEach
    void setUp() {
        // Initialize Mocks & create our service + repo
//        MockitoAnnotations.openMocks(this);
//        recipeService = new RecipeServiceDBImpl();
//        recipeService.setRecipeRepository(recipeRepository);
    }

    @Test
    void findAll() {
        // Arrange data
        List<Recipe> expectedRecipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        expectedRecipes.add(r1);

        // What is expected if the service works // Stub methods with when(...).thenReturn()
        when(recipeRepository.findAll()).thenReturn(expectedRecipes);

        // Act => actual results when using the service
        List<Recipe> actualRecipes = recipeService.findAll();

        // Assert => evaluate if both return the same
        assertEquals(actualRecipes, expectedRecipes);
    }
}
