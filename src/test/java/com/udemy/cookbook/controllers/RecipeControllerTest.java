package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.Recipe;
import com.udemy.cookbook.services.IRecipeService;
import org.hamcrest.Matchers;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
                .andExpect(jsonPath("$", hasSize(2)));
        verify(recipeService, times(1)).findAll();
    }

    @Test
    public void getARecipe() throws Exception {
        // Create data
        List<Recipe> expectedRecipe = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setId(1);
        expectedRecipe.add(r1);

        // What is supposed to happen:
        when(recipeController.getRecipe(1)).thenReturn(r1);

        // Act => Actual results
        mockMvc.perform(get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)));
        verify(recipeService, times(1)).findById(1);
        assertEquals(expectedRecipe.get(0), recipeController.getRecipe(1));
    }

    @Test
    public void createRecipe() throws Exception {
        List<Recipe> expectRecipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setId(1);
        r1.setName("cake");
        expectRecipes.add(r1);

        // What should theoretically happen:
        when(recipeController.createRecipe(r1)).thenReturn(r1);

        verify(recipeController, times(1)).createRecipe(r1);

        // What's actually happened:
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("cake")));
    }

    @Test
    public void editRecipe() throws Exception {
        List<Recipe> expectRecipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setName("cake");
        r1.setId(1);
        expectRecipes.add(r1);

        when(recipeService.save(r1)).thenReturn(r1);

        mockMvc.perform(put("/recipes/1")
                .param("recipe_id", "1"))
                .andExpect(status().isOk());

        verify(recipeService, times(1)).save(r1);
    }

    @Test
    public void deleteRecipt() throws Exception {
        List<Recipe> expectRecipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setName("cake");
        r1.setId(1);
        expectRecipes.add(r1);

        mockMvc.perform(delete("/recipes/1").param("recipe_id", "1"))
                .andExpect(status().isOk())
                .andReturn();

        verify(recipeService, times(1)).delete(1);
    }
}
