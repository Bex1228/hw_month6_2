package com.example.hw_month6_2.di

import com.example.hw_month6_2.ui.characterDetails.CharacterDetailsViewModel
import com.example.hw_month6_2.ui.characters.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        CharacterViewModel(get())
    }

    viewModel{
        CharacterDetailsViewModel(get())
    }
}