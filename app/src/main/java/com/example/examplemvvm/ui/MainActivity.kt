package com.example.examplemvvm.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.databinding.DetailProductBinding
import com.example.examplemvvm.model.model.Products
import com.example.examplemvvm.model.model.productsAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val productViewModel : ProductsViewModel by viewModels()
    var codeList = mutableListOf<Products>()
    var titleExample :String? = ""
    var searchClasses:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        productViewModel.onGetProducts()

        productViewModel.products.observe(this){
            codeList.clear()
            codeList.addAll(it)
            binding.recyclerTasks.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerTasks.adapter = productsAdapter(codeList, this)
        }
        Log.d("ExampleDetail", searchClasses)



        setContentView(binding.root)


    }

    fun buttonStar(title:String , descripcion:String, price:Double){
        val parameter = Bundle()
        parameter.apply {
            putString("title",title)
            putString("descripcion",descripcion)
            putDouble("price",price)
        }
        val intent = Intent(this@MainActivity, DetailProduct::class.java)
        intent.putExtras(parameter)
        startActivity(intent)
        finish()
    }

}

