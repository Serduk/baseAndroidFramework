package com.sserdiuk.baseadroidframework.utils

import com.github.slashrootv200.retrofithtmlconverter.HtmlConverterFactory
import retrofit2.Retrofit


/**
 *
 * Examples:
 * https://github.com/Serduk/whatWhereWhen/blob/master/app/src/main/java/com/sserdiuk/whatwherewhen/utilities/networkUtils/ChgkApi/ControllerChGK.java
 * https://github.com/Serduk/whatWhereWhen/blob/master/app/src/main/java/com/sserdiuk/whatwherewhen/utilities/networkUtils/ChgkApi/ControllerEx.java
 * https://www.baeldung.com/guide-to-okhttp
 * https://square.github.io/okhttp/
 * */
class NetworkUtil(baseUrl: String) {
    //    TODO(Add network listener)
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(HtmlConverterFactory.create(baseUrl))
            .build()
    }
}