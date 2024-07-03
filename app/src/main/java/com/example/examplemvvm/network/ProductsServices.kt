package com.example.examplemvvm.network


import android.util.Log
import com.example.examplemvvm.model.model.producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ProductsServices @Inject constructor(
    private val api:ProductsApiClient
){
    suspend fun getProducts(): List<producto> {
        return withContext(Dispatchers.IO){
            val response = api.getProducts()
            Log.d("ResponseSErives","$response")
            response.body()?.products?:emptyList()
        }
    }

}