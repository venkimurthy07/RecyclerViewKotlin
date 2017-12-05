package com.venkatesh.recyclerviewkotlin.dagger

import com.venkatesh.recyclerviewkotlin.category.CategoryModule
import com.venkatesh.recyclerviewkotlin.category.CategoryPresenterImpl
import com.venkatesh.recyclerviewkotlin.category.RecyclerMainActivity

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class,CategoryModule::class))
interface AppComponent {

    fun inject(inject: RecyclerMainActivity)


}