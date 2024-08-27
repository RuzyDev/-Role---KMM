package com.ruzy.maisrole.di

import com.ruzy.maisrole.network.KtorHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun apiModule(enableNetworkLogs: Boolean) = module {
    single { KtorHttpClient(get()).httpClient(enableNetworkLogs) }
}