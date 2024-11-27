package com.maxi.NYCSchoolsDetail


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxi.NYCSchoolsDetail.databinding.ProductItemBinding
import com.maxi.NYCSchoolsDetail.model.SchoolDetail
import com.maxi.NYCSchoolsDetail.model.SchoolDetailItem


class ProductListAdapter(private val productList: List<SchoolDetail>) : RecyclerView.Adapter<ProductListAdapter.ItemViewHolder>() {

     class ItemViewHolder(val binding : ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  ProductItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        with(holder) {
            with(productList[0]) {
                binding.productItemTitleTv.text =
                    productList.get(0).get(position).school_name
                binding.productItemAmtTv.text = productList.get(0).get(position).dbn
                binding.textView.text = productList.get(0).get(position).sat_math_avg_score
                binding.textView1.text = productList.get(0).get(position).num_of_sat_test_takers
            }
        }


    }


    override fun getItemCount(): Int {
        return productList.get(0).count()
    }
}