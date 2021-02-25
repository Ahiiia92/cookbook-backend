package com.udemy.cookbook.controllers;

import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.services.IFoodCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
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

    @PostMapping("/categories")
    public FoodCategory addCategories(@RequestBody FoodCategory category) {
        foodService.save(category);
        return foodService.findById(category.getId());
    }
}
