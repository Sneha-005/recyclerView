package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var codeList: ArrayList<code>, var context: Activity) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_code,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = codeList[position]
        holder.Title.text = currentItem.codeHeading
        holder.Image.setImageResource(currentItem.codeImage)
    }

    override fun getItemCount(): Int {
        return codeList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Title =itemView.findViewById<TextView>(R.id.heading)
        val Image =itemView.findViewById<ShapeableImageView>(R.id.image)

    }

}