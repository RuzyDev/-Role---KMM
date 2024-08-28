package com.ruzy.maisrole.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ruzy.maisrole.util.datastore.createDataStore
import com.ruzy.maisrole.util.datastore.dataStoreFileName


fun dataStore(context: Context): DataStore<Preferences> =
    createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )