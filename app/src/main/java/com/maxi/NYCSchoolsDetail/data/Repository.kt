package com.maxi.NYCSchoolsDetail.data

import com.maxi.NYCSchoolsDetail.data.remote.RemoteDataSource
import com.maxi.NYCSchoolsDetail.model.BaseApiResponse
import com.maxi.NYCSchoolsDetail.model.School
import com.maxi.NYCSchoolsDetail.model.SchoolDetail
import com.maxi.NYCSchoolsDetail.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getDetail(): Flow<NetworkResult<SchoolDetail>> {
        return flow<NetworkResult<SchoolDetail>> {
            emit(safeApiCall { remoteDataSource.getDetail() })
        }.flowOn(Dispatchers.IO)
    }

}
