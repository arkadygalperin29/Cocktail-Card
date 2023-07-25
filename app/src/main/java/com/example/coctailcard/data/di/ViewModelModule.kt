package com.example.coctailcard.data.di

import com.example.coctailcard.ui.category.CategoryViewModel
import com.example.coctailcard.ui.menuscreen.MenuScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun KoinApplication.viewModelModule() = module {
//    viewModel { MenuScreenViewModel(get()) }
    viewModel { params -> CategoryViewModel(get(), get(), page = params.get()) }
}
