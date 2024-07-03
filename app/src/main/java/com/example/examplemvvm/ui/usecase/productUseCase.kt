package com.example.examplemvvm.ui.usecase

import com.example.examplemvvm.model.model.Products
import com.example.examplemvvm.repositories.ProductsRepository
import okhttp3.RequestBody
import javax.inject.Inject



class productUseCase @Inject constructor(
    private var productsRepository: ProductsRepository
) {
    suspend operator fun invoke() : List<Products> {
        return productsRepository.getProductName()
    }
}