package com.venkatesh.recyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.venkatesh.recyclerviewkotlin.R.id.name
import kotlinx.android.synthetic.main.categoryitem.view.*

/**
 * Created by venkateshmurthy on 27/11/17.
 */
class CategoryAdapter(val categoryModel:  Array<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {





    override fun onBindViewHolder(holder: CategoryViewHolder?, position: Int) {
        val category = categoryModel.get(position)
        holder?.name?.setText(category.name)
        holder?.category?.setText(category.category)
        holder?.quantity?.setText(category.quantity)

    }

    override fun getItemCount(): Int {
        return categoryModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.categoryitem,parent,false))
    }


    class CategoryViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {

        var name:TextView = itemView!!.name
        var category:TextView = itemView!!.category
        var quantity:TextView = itemView!!.quanitity


    }


}