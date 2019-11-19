package com.sserdiuk.baseadroidframework.utils.foodApi

import org.jsoup.nodes.Document
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DobavkamNetApi {

    /**
     * @return html page with search results
     * */
    @GET("search/ru/{itemKey}")
    fun searchItems(@Path("itemKey") itemKey: String): Call<Document>

    /**
     * @return html page with item details
     */
    @GET("/products/{name}")
    fun openItemDetails(@Path("name") itemName: String): Call<Document>
}