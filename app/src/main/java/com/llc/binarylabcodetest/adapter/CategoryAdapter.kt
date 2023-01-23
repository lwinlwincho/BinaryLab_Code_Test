package com.llc.binarylabcodetest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.llc.binarylabcodetest.viewholder.VHCategory
import com.llc.binarylabcodetest.databinding.ItemCategoryBinding
import com.llc.binarylabcodetest.model.CategoryModel

class CategoryAdapter : ListAdapter<CategoryModel, VHCategory>(
    object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.courseName == newItem.courseName
        }

        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCategory {
        return VHCategory(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHCategory, position: Int) {
        holder.bind(getItem(position))
    }
}
