package com.github.leog_11.recipe_matching.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.service.RecipeService;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Recipe>> getAllRecipe() {
		List<Recipe> recipes = recipeService.getAllRecipe();
		return ResponseEntity.ok(recipes);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getRecipeByID(@PathVariable Long id){
		Recipe recipe = recipeService.getRecipeById(id);
		if(recipe == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(recipe);
	
		
	}
	@PostMapping()
	public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {
		Recipe recipeSave = recipeService.saveRecipe(recipe);
		
		 URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(recipeSave.getRecipeID())
                 .toUri();
		 return ResponseEntity.created(location).body(recipeSave);
		
	}
	// sends delete request and deletes it.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
			recipeService.deleteRecipe(id);
		return ResponseEntity.noContent().build();
		
		
	}
}
