package com.sserdiuk.baseadroidframework.utils

import java.net.URLDecoder
import java.net.URLEncoder

/**
 * Encode and Decode path for URL's
 * */
class UrlCoder {
    companion object {
        fun encodedQuery(string: String): String = URLEncoder.encode(string, "utf-8")
        fun decodedQuery(string: String): String = URLDecoder.decode(string, "utf-8")
    }
}