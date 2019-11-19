package com.sserdiuk.baseadroidframework.utils

import java.util.*

/**
 * Class helper for work with time and dates.
 * Convert current time to long
 * Get time and convert it from DB
 * etc
 * */
class DateAndTimeUtil {
    companion object {
        fun date(): CharSequence = android.text.format.DateFormat.format("HH:mm:ss dd/MM/yyyy", Date())
        fun dateAndTimeInMills(): Long = System.currentTimeMillis()
        fun dateFromMills(time: Long): CharSequence =
            android.text.format.DateFormat.format("HH:mm:ss dd/MM/yyyy", time)
    }
}