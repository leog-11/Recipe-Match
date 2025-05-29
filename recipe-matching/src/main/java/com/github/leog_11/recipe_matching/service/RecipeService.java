package com.github.leog_11.recipe_matching.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.repository.RecipeRepository;

import lombok.Data;

@Data
@Service
public class RecipeService {
	private RecipeRepository recipeRepository;
	// injects the repository into the service to use database methods
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
		
	}
	
	public Recipe getRecipeById(Long id) {
		return recipeRepository.findById(id).orElse(null);
		
	}
	public List<Recipe> getAllRecipe() {
		return recipeRepository.findAll();
		
	}
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
		
	}
	public void deleteRecipe(Long id) {
		recipeRepository.deleteById(id);
		
	}

}
