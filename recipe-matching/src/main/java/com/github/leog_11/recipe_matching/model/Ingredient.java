package com.github.leog_11.recipe_matching.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ingredientId;
	
	private String name;
	private String type;
	
	@OneToMany(mappedBy = "ingredient")
	@JsonIgnore 
	private List<RecipeIngredient> recipeIngredients;
	

}
