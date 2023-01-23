package com.llc.binarylabcodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.llc.binarylabcodetest.model.GridViewModel

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var courseList: List<GridViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test3=Test3()
        test3.main()

        val test4=Test4()
        test4.main()

        gridView = findViewById(R.id.grid_view)
        courseList = ArrayList<GridViewModel>()

        courseList = courseList + GridViewModel("Bussiness English", R.drawable.ic_notifications_24)
        courseList = courseList + GridViewModel("Grammer", R.drawable.ic_notifications_24)
        courseList = courseList + GridViewModel("Speaking", R.drawable.ic_notifications_24)
        courseList = courseList + GridViewModel("Phonetics", R.drawable.ic_notifications_24)
        courseList = courseList + GridViewModel("Writing", R.drawable.ic_notifications_24)
        courseList = courseList + GridViewModel("Listening", R.drawable.ic_notifications_24)


        val courseAdapter = GridViewAdapter(courseList = courseList, this@MainActivity)


        gridView.adapter = courseAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext, courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}