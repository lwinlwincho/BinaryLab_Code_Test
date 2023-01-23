package com.llc.binarylabcodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.llc.binarylabcodetest.adapter.CategoryAdapter
import com.llc.binarylabcodetest.adapter.PopularCourseAdapter
import com.llc.binarylabcodetest.databinding.ActivityMainBinding
import com.llc.binarylabcodetest.model.CategoryModel
import com.llc.binarylabcodetest.model.PopularCoursesModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var linearLayoutManager: LinearLayoutManager

    private val categoryAdapter by lazy {
        CategoryAdapter()
    }

    private val popularCourseAdapter by lazy {
        PopularCourseAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test3 = Test3()
        test3.main()

        val test4 = Test4()
        test4.main()

        gridLayoutManager = GridLayoutManager(this, 2)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvCategory.apply {
            layoutManager = gridLayoutManager
            adapter = categoryAdapter
        }

        binding.rvPopularCourses.apply {
            layoutManager = linearLayoutManager
            adapter = popularCourseAdapter
        }

        val categories = listOf(
            CategoryModel("Bussiness English", R.drawable.ic_business, R.color.business_color),
            CategoryModel("Grammer", R.drawable.ic_grammer, R.color.grammer_color),
            CategoryModel("Speaking", R.drawable.ic_speaking, R.color.speaking_color),
            CategoryModel("Phonetics", R.drawable.ic_phonetics, R.color.phonetics_color),
            CategoryModel("Writing", R.drawable.ic_writing, R.color.writing_color),
            CategoryModel("Listening", R.drawable.ic_listening, R.color.listening_color)
        )
        categoryAdapter.submitList(categories)


        val popularCourses = listOf(
            PopularCoursesModel("1", "How to write English Better", R.drawable.card_heading),
            PopularCoursesModel("2", "How to write English Better2", R.drawable.card_heading),
            PopularCoursesModel("3", "How to write English Better3", R.drawable.card_heading),
            PopularCoursesModel("4", "How to write English Better4", R.drawable.card_heading),
            PopularCoursesModel("5", "How to write English Better5", R.drawable.card_heading),
            PopularCoursesModel("6", "How to write English Better6", R.drawable.card_heading),
            PopularCoursesModel("7", "How to write English Better7", R.drawable.card_heading),
            PopularCoursesModel("8", "How to write English Better8", R.drawable.card_heading)
        )

        popularCourseAdapter.submitList(popularCourses)
    }
}