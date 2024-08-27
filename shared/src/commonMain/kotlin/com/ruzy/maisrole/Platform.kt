package com.ruzy.maisrole

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform