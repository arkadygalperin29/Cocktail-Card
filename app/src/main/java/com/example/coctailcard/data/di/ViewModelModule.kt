package com.example.coctailcard.data.di

import com.example.coctailcard.ui.category.CategoryViewModel
import com.example.coctailcard.ui.detailscreens.CocktailDetailViewModel
import com.example.coctailcard.ui.glassscreen.GlassViewModel
import com.example.coctailcard.ui.menuscreen.MenuScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun KoinApplication.viewModelModule() = module {
    viewModel { CategoryViewModel(get(), get()) }
    viewModel { MenuScreenViewModel(get()) }
    viewModel { CocktailDetailViewModel(get()) }
    viewModel { GlassViewModel(get())}
}
