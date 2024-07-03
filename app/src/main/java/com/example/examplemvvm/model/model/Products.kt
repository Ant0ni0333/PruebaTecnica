package com.example.examplemvvm.model.model


data class Products(
    val id :Int?,
    var title :String?,
    val description :String?,
    val price :Double?
)

fun producto.toDomain()=Products(id = id , title = title , description = description , price = price)