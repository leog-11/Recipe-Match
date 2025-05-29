package com.github.leog_11.recipe_matching.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.leog_11.recipe_matching.model.Recipe;
import com.github.leog_11.recipe_matching.model.RecipeIngredient;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
	List<RecipeIngredient> findByRecipe(Recipe recipe);

}
