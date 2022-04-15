package com.subhambikash.expandablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubAdapter(var list:ArrayList<SubSectionItemList>): RecyclerView.Adapter<SubAdapter.MyVieHolder>() {

   inner class MyVieHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val title:TextView=itemView.findViewById<TextView>(R.id.tittle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.sub_recycler_item_list,parent,false)
        return MyVieHolder(view)
    }

    override fun onBindViewHolder(holder: MyVieHolder, position: Int) {
        val listItems=list[position]
        holder.title.text=listItems.tittle
    }

    override fun getItemCount(): Int {
        return list.size
    }
}