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

import com.github.leog_11.recipe_matching.model.RecipeIngredient;
import com.github.leog_11.recipe_matching.service.RecipeIngredientService;


@RestController
@RequestMapping("/api/recipeIngredients")
public class RecipeIngredientController {
	
	private final RecipeIngredientService recipeIngredientService;
	
	public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
		this.recipeIngredientService = recipeIngredientService;
	}
	
	@GetMapping
	public ResponseEntity<List<RecipeIngredient>> getAllRecipeIngredient() {
		List<RecipeIngredient> recipeIngredients = recipeIngredientService.getAllRecipeIngredient();
		return ResponseEntity.ok(recipeIngredients);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<RecipeIngredient> getRecipeIngredientByID(@PathVariable Long id){
		RecipeIngredient recipeIngredient = recipeIngredientService.getRecipeIngredientById(id);
		if(recipeIngredient == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(recipeIngredient);
	
		
	}
	@PostMapping()
	public ResponseEntity<RecipeIngredient> saveRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
		RecipeIngredient recipeIngredientSave = recipeIngredientService.saveRecipeIngredient(recipeIngredient);
		 URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(recipeIngredientSave.getRecipeIngredientId())
                 .toUri();
		 return ResponseEntity.created(location).body(recipeIngredientSave);
		
	}
	// sends delete request and deletes it.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecipeIngredient(@PathVariable Long id) {
			recipeIngredientService.deleteRecipeIngredient(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	
	

}
