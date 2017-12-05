package com.venkatesh.recyclerviewkotlin

import android.support.multidex.MultiDexApplication
import com.venkatesh.recyclerviewkotlin.dagger.AppComponent
import com.venkatesh.recyclerviewkotlin.dagger.AppModule
import com.venkatesh.recyclerviewkotlin.dagger.DaggerAppComponent

/**
 * Created by venkateshmurthy on 28/11/17.
 */
class RecyclerApplication : MultiDexApplication() {


    var component: AppComponent? = null


    fun getAppComponent(): AppComponent? {
        return component
    }

    override fun onCreate() {
        super.onCreate()

        component = initDagger(this)

    }

    fun initDagger(application: RecyclerApplication): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(application)).build()

    }
}