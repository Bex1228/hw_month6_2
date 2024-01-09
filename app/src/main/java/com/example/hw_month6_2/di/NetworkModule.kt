package com.example.hw_month6_2.di

import org.koin.dsl.module

val networkModule = module {

    single {
        provideLoggingInterceptor()
    }

    single {
        provideOkHttpClient(get())
    }

    factory {
        provideRetrofit(get())
    }

    factory {
        provideCartoonApiService(get())
    }
}