package com.example.examplemvvm.repositories


import android.util.Log
import com.example.examplemvvm.model.model.Products
import com.example.examplemvvm.model.model.producto
import com.example.examplemvvm.model.model.toDomain
import com.example.examplemvvm.network.ProductsServices
import javax.inject.Inject



class ProductsRepository @Inject constructor(
    private val productsServices: ProductsServices
) {
    suspend fun getProductName(): List<Products> {
        val response: List<producto> = productsServices.getProducts()
        Log.d("services","$response")
        return response.map { it.toDomain() }
    }
}