package com.example.hw_month6_2.di

import com.example.hw_month6_2.data.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single{
        Repository(get())
    }
}