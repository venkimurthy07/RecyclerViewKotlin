package com.venkatesh.recyclerviewkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.JsonReader
import android.util.Log
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.nio.charset.Charset
import java.sql.Wrapper

/**
 * Created by venkateshmurthy on 27/11/17.
 */
class RecyclerMainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    fun init() {
        val recyclerView = findViewById<RecyclerView>(R.id.categorycycle)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val read = loadJSONFromAsset()
        if(read != null)
        {
            val gson = Gson()
            val json = gson.toJson(read)
            val `object` = gson.fromJson(json, Any::class.java)
            val topic = gson.fromJson(`object`.toString(), Array<CategoryModel>::class.java)
            recyclerView.adapter = CategoryAdapter(topic)

        }

    }

    fun loadJSONFromAsset(): String {
        var json: String? = null
        try {

            val `is` = assets.open("sample.json")

            val size = `is`.available()

            val buffer = ByteArray(size)

            `is`.read(buffer)

            `is`.close()


           json = String(buffer, Charset.forName("UTF-8"))


        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }

        return json

    }



}