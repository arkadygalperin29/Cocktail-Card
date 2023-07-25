package com.example.coctailcard.data.di

import com.example.coctailcard.ui.category.CategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun KoinApplication.viewModelModule() = module {
//    viewModel { MenuScreenViewModel(get()) }
    viewModel { params ->
        CategoryViewModel(
            alcoholicCocktailsRepository = get(),
            nonAlcoholicCocktailsRepository = get(),
            page = params.get()
        )
    }
}
