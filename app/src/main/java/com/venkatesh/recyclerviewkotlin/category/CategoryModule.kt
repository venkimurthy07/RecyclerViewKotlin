package com.venkatesh.recyclerviewkotlin.category

import android.content.Context
import com.venkatesh.recyclerviewkotlin.dagger.AppModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by venkateshmurthy on 29/11/17.
 */
@Module
class CategoryModule {

    @Provides
    @Singleton
     fun providesCategoryPresenter(context: Context): CategoryPresnter {
        return CategoryPresenterImpl(context)
    }

}