package com.udemy.cookbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FoodCategoryNotFoundException extends RuntimeException {
    public FoodCategoryNotFoundException(int id) {
        super("This FoodCategory with the id: " + id + " was not found");
    }
}
