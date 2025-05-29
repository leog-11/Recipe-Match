package com.github.leog_11.recipe_matching.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.leog_11.recipe_matching.model.Ingredient;
import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.model.RecipeIngredient;
import com.github.leog_11.recipe_matching.repository.IngredientRepository;
import com.github.leog_11.recipe_matching.repository.RecipeIngredientRepository;
import com.github.leog_11.recipe_matching.repository.RecipeRepository;

@Service
public class MatchingService {
	private RecipeRepository recipeRepository;
	private IngredientRepository ingredientRepository;
	private RecipeIngredientRepository recipeIngredientRepository;
	
	
	public MatchingService(RecipeRepository recipeRepository,IngredientRepository ingredientRepository, 
			RecipeIngredientRepository recipeIngredientRepository ){
		this.recipeRepository = recipeRepository;
		this.ingredientRepository = ingredientRepository;
		this.recipeIngredientRepository = recipeIngredientRepository;
	}

	
	public List<Recipe> findRecipesByAvailableIngredients(List<Ingredient> availableIngredients){
		List<Recipe> recipeList = recipeRepository.findAll();
	    List<Recipe> matchingRecipes = new ArrayList<>();

	    for(Recipe recipe: recipeList) {
	        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipe(recipe);
	        
	        int requiredCount = recipeIngredients.size();
	        int availableCount = 0;

	        for(RecipeIngredient recipeIngredient: recipeIngredients) {
	            Ingredient extractedIngredient = recipeIngredient.getIngredient();
	            if(availableIngredients.stream().anyMatch(available -> available.getIngredientId() == extractedIngredient.getIngredientId())){
	                availableCount++;
	            }
	        }

	        double matchPercentage = (double)availableCount / requiredCount * 100;
	        if(matchPercentage >= 80) {
	            matchingRecipes.add(recipe);
	        }
	    }
	    return matchingRecipes;
		
	}

}
