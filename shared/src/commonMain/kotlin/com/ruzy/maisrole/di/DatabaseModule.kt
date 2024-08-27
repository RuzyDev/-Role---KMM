package com.ruzy.maisrole.di

import com.ruzy.maisrole.database.MaisRoleDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { MaisRoleDatabase.invoke(driver = get()) }
}