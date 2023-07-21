package com.example.coctailcard.data.di

import com.example.coctailcard.ui.components.menuscreen.MenuScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun KoinApplication.viewModelModule() = module {
    viewModel { MenuScreenViewModel(get()) }
}