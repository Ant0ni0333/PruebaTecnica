package com.example.examplemvvm.model.model

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplemvvm.R
import com.example.examplemvvm.model.model.productsAdapter.Const.VIEW_TYPE_ITEM
import com.example.examplemvvm.ui.MainActivity


class productsAdapter(private val newsList:List<Products>, private val mainActivity: MainActivity) : RecyclerView.Adapter<productsViewHolder>(){

    object Const{
        const val VIEW_TYPE_ITEM = 0 // random unique value
        const val VIEW_TYPE_LOADING = 1
    }
    //Encargado de tomar los atributos y pintarlos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if (viewType == productsAdapter.Const.VIEW_TYPE_ITEM) {
            productsViewHolder(layoutInflater.inflate(R.layout.cards_producto, parent, false), viewType, activity = mainActivity)
        } else {
            productsViewHolder(layoutInflater.inflate(R.layout.item_loading, parent, false), viewType, activity = mainActivity)
        }
    }

    //Primero hacemos el viewHolder
    override fun onBindViewHolder(holder: productsViewHolder, position: Int) {
        val item = newsList[position]
        holder.render(item)
    }
    override fun getItemCount(): Int {
        return newsList.size
    }
    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_ITEM
    }
}