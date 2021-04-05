package com.sumigaborna.hiltpracticeapp.di

import com.sumigaborna.hiltpracticeapp.repository.MainRepository
import com.sumigaborna.hiltpracticeapp.retrofit.BlogRetrofit
import com.sumigaborna.hiltpracticeapp.retrofit.NetworkMapper
import com.sumigaborna.hiltpracticeapp.room.BlogDao
import com.sumigaborna.hiltpracticeapp.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}














