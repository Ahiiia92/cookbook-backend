package com.udemy.cookbook.services;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecipeServiceDBImplTest {
    @InjectMocks
    private RecipeServiceDBImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    List<Recipe> expectedRecipes;
    Recipe r1;


    @BeforeEach
    void setUp() {
        // Initialize Mocks & create our service + repo
//        MockitoAnnotations.openMocks(this);
//        recipeService = new RecipeServiceDBImpl();
//        recipeService.setRecipeRepository(recipeRepository);
        expectedRecipes = new ArrayList<>();
        r1 = new Recipe();
        r1.setId(1);
        r1.setName("newName");
        recipeRepository.save(r1);
        expectedRecipes.add(r1);

    }

    @Test
    void findAll() {
        // What is expected if the service works // Stub methods with when(...).thenReturn()
        when(recipeRepository.findAll()).thenReturn(expectedRecipes);

        // Act => actual results when using the service
        List<Recipe> actualRecipes = recipeService.findAll();

        // Assert => evaluate if both return the same
        assertEquals(actualRecipes, expectedRecipes);
    }

    @Test
    void findById() {
        // What is expected if the service works // Stub methods with when(...).thenReturn()
        when(recipeRepository.findById(r1.getId())).thenReturn(java.util.Optional.of(r1));

        // Act => Actual results when using the service
        Recipe actualRecipe = recipeService.findById(r1.getId());

        // Assert => Evaluate both return the same
        assertEquals(r1, actualRecipe);
    }

    @Test
    void save() {
        // what is expected to return if the service works // Stub method
        when(recipeRepository.save(r1)).thenReturn(r1);

        // Act => Actual results when we use the service
        Recipe actualRecipe = recipeService.save(r1);

        // Assert => Evaluate both return the same
        assertEquals(r1, actualRecipe);
    }

    @Test
    void delete() {
        // Act => Actual results when we use the service
        recipeService.delete(r1.getId());

        // Assert => verify the void method works
        Mockito.verify(recipeRepository, times(1)).deleteById(1);
    }

    @Test
    void updateRecipe() {
        // what is expected to return if the service works // Stub method
        when(recipeRepository.findById(1)).thenReturn(java.util.Optional.of(r1));

        // Act
        Recipe actualRecipe = recipeService.updateRecipe(r1.getId(), r1);

        // Assert
        assertEquals(r1, actualRecipe);
    }
}
