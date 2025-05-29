package com.github.leog_11.recipe_matching.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
public class Recipe {
	// randomly generates an id for each key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recipeID;
	
	@OneToMany(mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredients;
	
	
	private String name;
	private String description;
	private String recipeDifficulty;
	@Column(length = 1000) private String instructions;
	private String cookingTime;
	private String preparationTime;
	private String recipeType;
	private String cuisine;
	private int servings;
	

}
