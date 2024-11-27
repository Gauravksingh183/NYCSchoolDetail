package com.maxi.NYCSchoolsDetail.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val dService: DetailssService) {

    suspend fun getDetail() =
        dService.getDetails()

}