package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.services.IFoodCategoryService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class CategoryControllerTest {
    @InjectMocks
    private CategoryController controller;

    @Mock
    private IFoodCategoryService foodCategoryService;

    // Mockmvc is private final / constant and therefore can not be mocked
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Initialize mockmvc
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getFoodCategories() throws Exception {
        List<FoodCategory> expectedCategory = new ArrayList<>();
        FoodCategory c1 = new FoodCategory();
        expectedCategory.add(c1);

        when(foodCategoryService.findAll()).thenReturn(expectedCategory);

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$",hasSize(1)));
        // verify can only be used with @moch properties not @injectmock
        verify(foodCategoryService, times(1)).findAll();
    }
}
