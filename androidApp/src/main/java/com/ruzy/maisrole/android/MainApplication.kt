package com.ruzy.maisrole.android

import android.app.Application
import com.ruzy.maisrole.di.initKoin
import com.ruzy.maisrole.presentation.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(level = Level.NONE)
            androidContext(androidContext = this@MainApplication)
        }
    }
}
