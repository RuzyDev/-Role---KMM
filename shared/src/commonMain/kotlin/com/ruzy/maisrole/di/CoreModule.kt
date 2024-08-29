package com.ruzy.maisrole.di

import com.ruzy.maisrole.database.MaisRoleDatabase
import com.ruzy.maisrole.domain.interactor.InsertRandomAnime
import com.ruzy.maisrole.domain.observers.ObserveAnimes
import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.domain.repository.impl.MaisRoleRepositoryImpl
import com.ruzy.maisrole.network.datasource.MaisRoleDataSource
import com.ruzy.maisrole.network.service.MaisRoleService
import com.ruzy.maisrole.util.AppCoroutineDispatchers
import com.ruzy.maisrole.util.datastore.MaisRoleDataStore
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val coreModule = module {
    single { Json { ignoreUnknownKeys = true } }
    single {
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            computation = Dispatchers.Default,
            main = Dispatchers.Main
        )
    }
    single { MaisRoleDataStore(get()) }

    single<MaisRoleService> { MaisRoleDataSource(get()) }
    single<MaisRoleRepository> { MaisRoleRepositoryImpl(
       maisRoleDataSource =  get(),
        animeQueries = get<MaisRoleDatabase>().animeQueries)
    }

    //Domains
    single { ObserveAnimes(get()) }
    single { InsertRandomAnime(get(),get()) }
}