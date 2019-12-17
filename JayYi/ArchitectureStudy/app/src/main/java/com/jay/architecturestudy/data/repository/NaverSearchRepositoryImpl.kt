package com.jay.architecturestudy.data.repository

import com.jay.architecturestudy.data.model.ResponseBlog
import com.jay.architecturestudy.data.model.ResponseImage
import com.jay.architecturestudy.data.model.ResponseKin
import com.jay.architecturestudy.data.model.ResponseMovie
import com.jay.architecturestudy.data.source.remote.NaverSearchRemoteDataSource
import com.jay.architecturestudy.data.source.remote.NaverSearchRemoteDataSourceImpl

class NaverSearchRepositoryImpl : NaverSearchRepository {
    override val naverSearchRemoteDataSource: NaverSearchRemoteDataSource by lazy {
        NaverSearchRemoteDataSourceImpl()
    }

    override fun getMovie(
        keyword: String,
        success: (ResponseMovie) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        naverSearchRemoteDataSource.getMovie(
            keyword = keyword,
            success = success,
            fail = fail
        )
    }

    override fun getImage(
        keyword: String,
        success: (ResponseImage) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        naverSearchRemoteDataSource.getImage(
            keyword = keyword,
            success = success,
            fail = fail
        )
    }

    override fun getBlog(
        keyword: String,
        success: (ResponseBlog) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        naverSearchRemoteDataSource.getBlog(
            keyword = keyword,
            success = success,
            fail = fail
        )
    }

    override fun getKin(
        keyword: String,
        success: (ResponseKin) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        naverSearchRemoteDataSource.getKin(
            keyword = keyword,
            success = success,
            fail = fail
        )
    }

}