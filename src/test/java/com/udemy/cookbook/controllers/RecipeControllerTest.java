package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.services.IRecipeService;
import com.udemy.cookbook.services.RecipeServiceDBImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
public class RecipeControllerTest {
    // Class we want to test
    @InjectMocks
    RecipeController recipeController;

    // Our dependencies
    @Mock
    private IRecipeService recipeService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Initialize mockmvc
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void getRecipes() throws Exception {
        // Create data
        List<Recipe> expectedReecipe = new ArrayList<>();
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        expectedReecipe.add(r1);
        expectedReecipe.add(r2);

        // What is supposed to happen:
        when(recipeService.findAll()).thenReturn(expectedReecipe);

        // Act => actual results:
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$",hasSize(2)));
        verify(recipeService, times(1)).findAll();
    }
}
