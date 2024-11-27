package com.maxi.NYCSchoolsDetail.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.maxi.NYCSchoolsDetail.data.Repository
import com.maxi.NYCSchoolsDetail.model.School
import com.maxi.NYCSchoolsDetail.model.SchoolDetail
import com.maxi.NYCSchoolsDetail.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<SchoolDetail>> = MutableLiveData()
    val response: LiveData<NetworkResult<SchoolDetail>> = _response

    fun fetchResponse() = viewModelScope.launch {
        repository.getDetail().collect { values ->
            _response.value = values
        }
    }

}