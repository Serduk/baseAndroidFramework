package com.sserdiuk.baseadroidframework.utils

import java.lang.Exception

class FrameworkException(text: String = "Something went wrong") : Exception() {
    init {
        println(text)
    }
}