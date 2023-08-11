package com.example.coctailcard.domain

import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.data.network.models.IngredientDetailed

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
)