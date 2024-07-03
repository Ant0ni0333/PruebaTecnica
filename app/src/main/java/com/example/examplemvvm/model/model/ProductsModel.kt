package com.example.examplemvvm.model.model

import com.google.gson.annotations.SerializedName

data class productsResponse(@SerializedName("products") val products: List<producto>)

data class producto(
    @SerializedName("id") val id :Int?,
    @SerializedName("title") val title :String?,
    @SerializedName("description") val description :String?,
    @SerializedName("price") val price :Double?,
)