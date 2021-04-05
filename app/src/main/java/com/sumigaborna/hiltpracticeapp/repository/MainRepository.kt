package com.sumigaborna.hiltpracticeapp.repository

import com.sumigaborna.hiltpracticeapp.retrofit.BlogRetrofit
import com.sumigaborna.hiltpracticeapp.retrofit.NetworkMapper
import com.sumigaborna.hiltpracticeapp.room.BlogDao
import com.sumigaborna.hiltpracticeapp.room.CacheMapper
import com.sumigaborna.hiltpracticeapp.model.Blog
import com.sumigaborna.hiltpracticeapp.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getBlogs(): kotlinx.coroutines.flow.Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogRetrofit.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}