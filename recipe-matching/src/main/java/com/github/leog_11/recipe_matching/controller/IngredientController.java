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

import com.github.leog_11.recipe_matching.model.Ingredient;
import com.github.leog_11.recipe_matching.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
	private final IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}
	
	@GetMapping
	public ResponseEntity<List<Ingredient>> getAllIngredient() {
		List<Ingredient> ingredients = ingredientService.getAllIngredient();
			return ResponseEntity.ok(ingredients);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> getIngredientByID(@PathVariable Long id){
		Ingredient ingredient = ingredientService.getIngredientById(id);
		if(ingredient == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ingredient);
	
		
	}
	@PostMapping()
	public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
		Ingredient ingredientSave = ingredientService.saveIngredient(ingredient);
		
		 URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(ingredientSave.getIngredientId())
                 .toUri();
		 return ResponseEntity.created(location).body(ingredientSave);
		
	}
	// sends delete request and deletes it.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
			ingredientService.deleteIngredient(id);
		return ResponseEntity.noContent().build();
		
		
	}
}


