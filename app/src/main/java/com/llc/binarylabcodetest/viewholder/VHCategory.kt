package com.llc.binarylabcodetest.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.llc.binarylabcodetest.databinding.ItemCategoryBinding
import com.llc.binarylabcodetest.model.CategoryModel

class VHCategory(
    private val binding: ItemCategoryBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: CategoryModel) {
        binding.ivCourseImage.setImageResource(model.courseImg)
        binding.tvCourseName.text = model.courseName
        binding.llRoot.setBackgroundResource(model.bgColor)
    }
}
