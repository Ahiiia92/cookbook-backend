package com.udemy.cookbook.services;

import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.repositories.FoodCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodCategoryServiceDBImpl implements IFoodCategoryService {
    // Constructor Injection
    private final FoodCategoryRepository repo;

    public FoodCategoryServiceDBImpl(FoodCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<FoodCategory> findAll() {
        return repo.findAll();
    }
}
