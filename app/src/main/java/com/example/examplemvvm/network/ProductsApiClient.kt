package com.example.examplemvvm.network

import com.example.examplemvvm.model.model.productsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface ProductsApiClient {
    @GET("products")
    suspend fun getProducts(): Response<productsResponse>
}