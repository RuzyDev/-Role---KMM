package com.ruzy.maisrole.util

import korlibs.crypto.md5

object AppChecker {

    /**
     * Checks the generated MD5 hash against the hash saved in Constants.
     */
    @Throws(IllegalStateException::class)
    fun checkTimeZoneHash() {
        check(Constants.conferenceTimeZoneHash == toMD5("${Constants.conferenceTimeZone.id}|${Constants.Sessionize.scheduleId}")) {
            "TimeZone hash is incorrect."
        }
    }

    private fun toMD5(text: String): String {
        return text.encodeToByteArray().md5().hex
    }
}
