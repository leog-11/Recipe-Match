package com.github.leog_11.recipe_matching.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.leog_11.recipe_matching.model.Ingredient;
import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.service.MatchingService;

@RestController
@RequestMapping("/api/matching/recipes")
public class MatchingController {
	private MatchingService matchingService;
	
	public MatchingController(MatchingService matchingService) {
		this.matchingService= matchingService;
	}
	
	@PostMapping
	public ResponseEntity<List<Recipe>> findRecipesByAvailableIngredients(@RequestBody List<Ingredient> ingredients){
		List<Recipe> matchingRecipes = matchingService.findRecipesByAvailableIngredients(ingredients);
		return ResponseEntity.ok(matchingRecipes);
	}
	
}
