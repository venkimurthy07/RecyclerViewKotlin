package com.venkatesh.recyclerviewkotlin

import com.google.gson.annotations.SerializedName

/**
 * Created by venkateshmurthy on 27/11/17.
 */
data class CategoryModel(@SerializedName("id") val id:String,
                         @SerializedName("category") val category:String,
                         @SerializedName("name") val name:String,
                         @SerializedName("quantity") val quantity:String) {




}