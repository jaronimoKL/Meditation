package com.example.meditation.recapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.R
import com.example.meditation.recapters.FeelRecycler2.*
import com.example.meditation.state

class FeelRecycler2(val context: Context, val list: ArrayList<state>): RecyclerView.Adapter<MyVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter2,parent,false)
        return MyVH(root)
    }

    class MyVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView2:TextView = itemView.findViewById(R.id.text_feel2)
        val textView3:TextView = itemView.findViewById(R.id.text_feel3)
        val image2:ImageView = itemView.findViewById(R.id.img_feel2)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.textView2.setText(list[position].title)
        holder.textView3.setText(list[position].text_state)
        holder.image2.setImageResource(list[position].image_state)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}