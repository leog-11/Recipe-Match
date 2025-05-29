package com.github.leog_11.recipe_matching.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.model.RecipeIngredient;
import com.github.leog_11.recipe_matching.repository.RecipeIngredientRepository;

import lombok.Data;

@Data
@Service

public class RecipeIngredientService {
	private RecipeIngredientRepository recipeIngredientRepository;
	// injects the repository into the service to use database methods
	public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
		this.recipeIngredientRepository = recipeIngredientRepository;
		
	}
	
	public RecipeIngredient getRecipeIngredientById(Long id) {
		return recipeIngredientRepository.findById(id).orElse(null);
		
	}
	
	
	public List<RecipeIngredient> getAllRecipeIngredient() {
		return recipeIngredientRepository.findAll();
		
	}
	public RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient) {
		return recipeIngredientRepository.save( recipeIngredient);
		
	}
	
	public List<RecipeIngredient> getRecipeIngredientsByRecipe(Recipe recipe) {
	    return recipeIngredientRepository.findByRecipe(recipe);
	}
	public void deleteRecipeIngredient(Long id) {
		recipeIngredientRepository.deleteById(id);
		
	}
	

}
