package com.sserdiuk.baseadroidframework.utils.foodApi

import com.sserdiuk.baseadroidframework.data.DetailsItemModel
import com.sserdiuk.baseadroidframework.data.SearchItemModel
import com.sserdiuk.baseadroidframework.utils.NetworkUtil
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * HTML Converter work solution
 * https://www.javatpoint.com/install-jsoup
 * +
 * https://github.com/slashrootv200/retrofit2-html-converter
 * Syntax for querying: https://jsoup.org/cookbook/extracting-data/selector-syntax
 * */
class FoodSearchController(
    networkUtil: NetworkUtil,
    var searchRequest: SearchItemsRequest<List<SearchItemModel>>? = null,
    var itemRequest: SearchItemsRequest<DetailsItemModel>? = null
) {
    private val foodApi: DobavkamNetApi = networkUtil.retrofit.create(DobavkamNetApi::class.java)

    /**
     * Send request to server for getting body with food search results
     * Parse results from search results page
     * Page return data in HTML
     * After this return correct data for recycler
     * Used in
     * @see com.sserdiuk.foodscanner.screens.search.SearchActivity
     * */
//    TODO: Fix parsing for more than one pages with results
    fun getSearchResults(key: String) {
        val call: Call<Document> = foodApi.searchItems(key)
        call.enqueue(object : Callback<Document> {
            override fun onResponse(call: Call<Document>, response: Response<Document>) {
                val items: ArrayList<SearchItemModel> = ArrayList()
                val myItem = response.body()
                val results: Elements? = myItem?.select("ol.search-results > div")
                results?.forEach {
                    val itemCount: String? = it.select("div.t-info-1 > h3").text()
                    it.select("div.t-info-1 > h3").remove()
                    val desc: String? = it.select("div.t-info-1").html().replace("<br>", "\n")
                    val vendor: String? = it.select("div.t-info-2").html()
                        .replace("<br>", "")
                        .replace("<h3>", "")
                        .replace("</h3>", " ")
                    val name: String? = it.select("h2 > a").text()
                    val sImagePath: String? = it.select("img.image-style-s").attr("src")
                        .split("?")[0]
                    val mImagePath: String? = it.select("img.image-style-s").attr("src")
                        .split("?")[0].replace("/s/", "/m/")
                    val linkToItem: String? = it.select("a[href]").first().attr("href")
                    val shortPath: String? = it.select("a[href]").first().attr("href")
                        .split("/products/").last()

                    if (!name.isNullOrEmpty() && !itemCount.isNullOrEmpty() && !desc.isNullOrEmpty()
                        && !vendor.isNullOrEmpty() && !sImagePath.isNullOrEmpty() && !mImagePath.isNullOrEmpty()
                        && !linkToItem.isNullOrEmpty() && !shortPath.isNullOrEmpty()
                    ) {
                        items.add(
                            SearchItemModel(
                                name = name,
                                quantity = itemCount,
                                consist = desc,
                                vendor = vendor,
                                sImagePath = sImagePath,
                                mImagePath = mImagePath,
                                linkToItem = linkToItem,
                                shortPath = shortPath
                            )
                        )
                    }
                }
                searchRequest?.onSuccessRequest(items)
            }

            override fun onFailure(call: Call<Document>, t: Throwable) {
                searchRequest?.onFailureRequest(t.localizedMessage)
            }
        })
    }

    fun getItemDetails(key: String): DetailsItemModel? {
        val call: Call<Document> = foodApi.openItemDetails(key)
        val itemDetails = DetailsItemModel()
        call.enqueue(object : Callback<Document> {
            override fun onResponse(call: Call<Document>, response: Response<Document>) {
                val itemData = DetailsItemModel()
                itemRequest?.onSuccessRequest(itemData)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<Document>, t: Throwable) {
                itemRequest?.onFailureRequest(t.localizedMessage)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return itemDetails
    }
}

interface SearchItemsRequest<E> {
    fun onSuccessRequest(items : E)
    fun onFailureRequest(message: String)
}