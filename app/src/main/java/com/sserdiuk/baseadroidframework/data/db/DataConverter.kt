package com.sserdiuk.baseadroidframework.data.db

import com.sserdiuk.baseadroidframework.utils.FrameworkException
import java.util.*

/**
 * Time converter for room DB
 *
 *
 * Created by sserdiuk on 3/23/18.
 */

// TODO("Implement me")
object DataConverter {
    @Throws(FrameworkException::class)
//    @TypeConverter
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    //    @TypeConverter
    fun toLong(value: Date?): Long? {
        return value?.time
    }
}