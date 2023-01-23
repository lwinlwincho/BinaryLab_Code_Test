package com.llc.binarylabcodetest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.llc.binarylabcodetest.databinding.ItemPopularCoursesBinding
import com.llc.binarylabcodetest.model.PopularCoursesModel
import com.llc.binarylabcodetest.viewholder.VHPopularCourse

class PopularCourseAdapter : ListAdapter<PopularCoursesModel, VHPopularCourse>(
    object : DiffUtil.ItemCallback<PopularCoursesModel>() {
        override fun areContentsTheSame(
            oldItem: PopularCoursesModel,
            newItem: PopularCoursesModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(
            oldItem: PopularCoursesModel,
            newItem: PopularCoursesModel
        ): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPopularCourse {
        return VHPopularCourse(
            ItemPopularCoursesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHPopularCourse, position: Int) {
        holder.bind(getItem(position))
    }
}
