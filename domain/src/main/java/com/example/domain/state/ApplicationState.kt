package com.example.domain.state

import com.example.domain.Cocktail
import com.example.domain.Glass
import com.example.domain.Ingredient
import com.example.domain.IngredientDetailed

data class ApplicationState(
    val isLoading: Boolean = false,
    val searchQuery: String? = null,
    val cocktails: List<Cocktail> = emptyList(),
    val cocktail: Cocktail? = null,
    val glasses: List<Glass> = emptyList(),
    val ingredients: List<Ingredient> = emptyList(),
    val ingredient: IngredientDetailed? = null,
    val alcoholicCocktails: List<Cocktail> = emptyList(),
    val nonAlcoholicCocktails: List<Cocktail> = emptyList(),
    val selectedButton: Int = 0,
    val favoriteCocktails: List<Cocktail> = emptyList(),
    val itemAlreadyExistsInDatabase: Boolean = false
)