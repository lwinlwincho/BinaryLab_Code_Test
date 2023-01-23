package com.llc.binarylabcodetest.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.llc.binarylabcodetest.databinding.ItemPopularCoursesBinding
import com.llc.binarylabcodetest.model.PopularCoursesModel

class VHPopularCourse(
    private val binding: ItemPopularCoursesBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: PopularCoursesModel) {
        binding.ivCourseImage.setImageResource(model.image)
        binding.tvSubtitle.text = model.subtitle
    }
}
