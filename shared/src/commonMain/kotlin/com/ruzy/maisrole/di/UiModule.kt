package com.ruzy.maisrole.di

import com.ruzy.maisrole.presentation.HomeViewModel
import org.koin.dsl.module

val uiModule = module {
    single { HomeViewModel(get()) }
}