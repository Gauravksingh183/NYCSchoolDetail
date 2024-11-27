package com.maxi.NYCSchoolsDetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxi.NYCSchoolsDetail.databinding.ActivityMainBinding
import com.maxi.NYCSchoolsDetail.utils.NetworkResult
import com.maxi.NYCSchoolsDetail.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()
        _binding.imgRefresh.setOnClickListener {
            fetchResponse()
        }
    }

    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        _binding.recyclerView.layoutManager = LinearLayoutManager(this)

                        _binding.recyclerView.adapter = ProductListAdapter(listOf(it))

                    }
                    _binding.pbDetail.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    _binding.pbDetail.visibility = View.GONE
                    Toast.makeText(
                        this, response.message, Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    _binding.pbDetail.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun fetchResponse() {
        mainViewModel.fetchResponse()
        _binding.pbDetail.visibility = View.VISIBLE
    }
}
