package com.ruzy.maisrole.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.ruzy.maisrole.database.MaisRoleDatabase

actual class SqlDelightDriverFactory(
    private val context: Context,
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MaisRoleDatabase.Schema, context, "maisrole.db")
    }
}
