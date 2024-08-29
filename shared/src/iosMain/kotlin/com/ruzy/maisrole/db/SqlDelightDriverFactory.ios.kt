package com.ruzy.maisrole.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.ruzy.maisrole.database.MaisRoleDatabase

actual class SqlDelightDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MaisRoleDatabase.Schema, "maisrole.db")
    }
}
