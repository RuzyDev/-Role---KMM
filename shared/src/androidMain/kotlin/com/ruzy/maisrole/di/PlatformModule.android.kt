package com.ruzy.maisrole.di

import app.cash.sqldelight.db.SqlDriver
import com.ruzy.maisrole.db.SqlDelightDriverFactory
import com.ruzy.maisrole.util.dataStore
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> {
        SqlDelightDriverFactory(context = get()).createDriver()
    }

    single<HttpClientEngine> {
        OkHttp.create {}
    }

    single { dataStore(get())}
}
