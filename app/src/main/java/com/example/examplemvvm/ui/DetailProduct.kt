package com.example.examplemvvm.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examplemvvm.databinding.DetailProductBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailProduct : AppCompatActivity() {
    private lateinit var binding: DetailProductBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailProductBinding.inflate(layoutInflater)

        val bundle = intent.extras
        val titleProduct = bundle?.getString("title", "")
        val descripcionProduct = bundle?.getString("descripcion","")
        val price = bundle?.getDouble("price",0.0)


        binding.ProductName.text = titleProduct
        binding.DescriptionProduct.text =  descripcionProduct
        binding.PriceProduct.text = price.toString()

        binding.ButtonReturn.setOnClickListener {
            val intent = Intent(this@DetailProduct, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        setContentView(binding.root)


    }
}