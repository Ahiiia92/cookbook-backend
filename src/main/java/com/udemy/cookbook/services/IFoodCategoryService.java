package com.udemy.cookbook.services;

import com.udemy.cookbook.models.FoodCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFoodCategoryService {
    List<FoodCategory> findAll();
}
