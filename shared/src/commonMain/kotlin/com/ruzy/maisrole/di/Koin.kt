package com.ruzy.maisrole.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = true, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(platformModule, apiModule(enableNetworkLogs), coreModule, databaseModule, uiModule)
    }

// called by iOS etc
// fun initKoin() = initKoin(enableNetworkLogs = false) {}

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }
