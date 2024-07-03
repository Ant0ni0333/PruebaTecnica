package com.example.examplemvvm.ui


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.model.model.Products
import com.example.examplemvvm.ui.usecase.productUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: productUseCase

): ViewModel(){

    val products = MutableLiveData<List<Products>>()

    fun onGetProducts() {
        viewModelScope.launch {
            products.postValue(getProductsUseCase.invoke())
        }
    }
}