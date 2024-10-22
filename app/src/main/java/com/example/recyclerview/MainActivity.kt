package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.R


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var codeList : ArrayList<code>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)



        var codeImageArray = arrayOf(
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,
            R.drawable.gfg,

        )

        var codeHeadingArray = arrayOf(
            "DSA in C",
            "DSA in C++",
            "DSA in Python",
            "DSA in Java",
            "Course in HTML",
            "Course in CSS",
            "Course in javascript",
            "Course in android",
            "Course in flask",

        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        codeList = arrayListOf<code>()

        for (index in codeImageArray.indices){
            val code = code(codeHeadingArray[index],codeImageArray[index])
            codeList.add(code)
        }

        recyclerView.adapter = MyAdapter(codeList,this)
    }
}