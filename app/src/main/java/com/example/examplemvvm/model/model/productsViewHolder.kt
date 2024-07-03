package com.example.examplemvvm.model.model

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.examplemvvm.databinding.CardsProductoBinding
import com.example.examplemvvm.databinding.DetailProductBinding
import com.example.examplemvvm.ui.MainActivity


class productsViewHolder(view: View, viewType: Int, activity: MainActivity) : RecyclerView.ViewHolder(view) {

    object Const {
        const val VIEW_TYPE_ITEM = 0 // random unique value
        const val VIEW_TYPE_LOADING = 1
    }

    val fragmentRef = activity
    val viewRef = view
    val viewTypeRef = viewType
    val binding = CardsProductoBinding.bind(viewRef)


    fun render(newModel: Products) {
        if (viewTypeRef == productsAdapter.Const.VIEW_TYPE_ITEM) {

            binding.listItemAxxo.setOnClickListener {
                 fragmentRef.buttonStar(newModel.title.toString(),newModel.description.toString(),newModel.price!!)
            }

      binding.titleProducts.text = newModel.title
      binding.titleProductsDescription.text = newModel.description
            binding.price.text = newModel.price.toString()
        }

    }
}
