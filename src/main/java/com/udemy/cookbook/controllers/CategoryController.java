package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.services.IFoodCategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    // @Autowired ==> Not required anymore due to the constructor injection.
    // final = constant???
    // Constructor Injection
    private final IFoodCategoryService foodService;

    public CategoryController(IFoodCategoryService foodCategoryService) {
        this.foodService = foodCategoryService;
    }

    @GetMapping("/categories")
    public List<FoodCategory> getFoodCategories() { return foodService.findAll(); }
}
