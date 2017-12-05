package com.venkatesh.recyclerviewkotlin.category

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * Created by venkateshmurthy on 29/11/17.
 */

 class CategoryPresenterImpl @Inject constructor(context: Context) : CategoryPresnter{

    var context: Context? = null

    init {
        this.context = context
    }



    override fun loadJSONFromAsset(): String {
        var json: String? = null
        try {

            val `is` = context?.assets?.open("sample.json")

            val size = `is`?.available()

            val buffer = size?.let { ByteArray(it) }

            `is`?.read(buffer)

            `is`?.close()


            json = buffer?.let { String(it, Charset.forName("UTF-8")) }


        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }

        return json!!

    }
}

