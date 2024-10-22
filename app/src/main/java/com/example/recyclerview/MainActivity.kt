package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


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

        val codeContent = arrayOf(

            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),
            getString(R.string.code_content),



        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        codeList = arrayListOf<code>()

        for (index in codeHeadingArray.indices){
            val code = code(codeHeadingArray[index],codeImageArray[0],codeContent[index])
            codeList.add(code)
        }

        var myAdapter = MyAdapter(codeList , this)

        recyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent =Intent(applicationContext, codeDetail::class.java)
                intent.putExtra("heading",codeList[position].codeHeading)
                intent.putExtra("imageId",codeList[position].codeImage)
                intent.putExtra("content",codeList[position].codeContent)
                startActivity(intent)

            }

        })

    }
}