package com.github.leog_11.recipe_matching.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
// relationship between recipe and ingredient
public class RecipeIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recipeIngredientId;
	private String quantity;
	private String units;
	
	
	@ManyToOne
	@JsonIgnore 
	private Recipe recipe;
	@ManyToOne
	
	private Ingredient ingredient;
	
		

}
