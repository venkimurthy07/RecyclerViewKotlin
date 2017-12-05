package com.venkatesh.recyclerviewkotlin.category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.nio.charset.Charset
import javax.inject.Inject
import com.venkatesh.recyclerviewkotlin.CategoryAdapter
import com.venkatesh.recyclerviewkotlin.CategoryModel
import com.venkatesh.recyclerviewkotlin.R
import com.venkatesh.recyclerviewkotlin.RecyclerApplication


/**
 * Created by venkateshmurthy on 27/11/17.
 */
class RecyclerMainActivity : AppCompatActivity() {


    @Inject
    lateinit var presenter: CategoryPresnter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as RecyclerApplication).getAppComponent()?.inject(this)

        init()

    }


    fun init() {

        categorycycle.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,
                false)

        val read = presenter.loadJSONFromAsset()
        if (read != null) {
            val gson = Gson()
            val json = gson.toJson(read)
            val `object` = gson.fromJson(json, Any::class.java)
            val topic = gson.fromJson(`object`.toString(), Array<CategoryModel>::class.java)
            categorycycle.adapter = CategoryAdapter(topic)

        }

    }


}