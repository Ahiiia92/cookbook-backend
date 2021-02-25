package com.udemy.cookbook.services;

import com.udemy.cookbook.exceptions.FoodCategoryNotFoundException;
import com.udemy.cookbook.models.FoodCategory;
import com.udemy.cookbook.repositories.FoodCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void save(FoodCategory category) {
        repo.save(category);
    }

    @Override
    public FoodCategory findById(Integer id) {
        Optional<FoodCategory> optCategory = repo.findById(id);
        if(optCategory.isPresent())
            return optCategory.get();
        else
            throw new FoodCategoryNotFoundException(id);
    }
}
