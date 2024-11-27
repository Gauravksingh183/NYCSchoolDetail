package com.maxi.NYCSchoolsDetail.data.remote

import com.maxi.NYCSchoolsDetail.model.SchoolDetail
import retrofit2.Response
import retrofit2.http.GET

interface DetailssService {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getDetails(): Response<SchoolDetail>
}
