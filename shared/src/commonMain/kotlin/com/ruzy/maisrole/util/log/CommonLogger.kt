package com.ruzy.maisrole.util.log

expect interface CommonLogger {
    open fun log(tag: String, message: String)
}