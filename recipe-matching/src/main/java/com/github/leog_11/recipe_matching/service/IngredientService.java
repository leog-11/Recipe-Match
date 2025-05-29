package com.github.leog_11.recipe_matching.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.leog_11.recipe_matching.model.Ingredient;
import com.github.leog_11.recipe_matching.repository.IngredientRepository;

@Service
public class IngredientService {
	private IngredientRepository ingredientRepository;
	// injects the repository into the service to use database methods
	public IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
		
	}
	
	public Ingredient getIngredientById(Long id) {
		return ingredientRepository.findById(id).orElse(null);
		
	}
	public List<Ingredient> getAllIngredient() {
		return ingredientRepository.findAll();
		
	}
	public Ingredient saveIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
		
	}
	public void deleteIngredient(Long id) {
		ingredientRepository.deleteById(id);
		
	}

}
