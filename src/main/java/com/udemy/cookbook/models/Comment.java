package com.udemy.cookbook.models;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String commentContent;

    // Comment goes back to Recipe.
    @ManyToOne
    private Recipe recipe;
}
