package com.subhambikash.expandablerecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context:Context, private var itemList:ArrayList<ListItemModel>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {



    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val heading:TextView=itemView.findViewById(R.id.tittle)
        val sections:TextView=itemView.findViewById(R.id.sections)
        var layout:RelativeLayout=itemView.findViewById(R.id.subLayout)
        val subRecyclerView:RecyclerView=itemView.findViewById(R.id.subItemRecyclerView)
        val icon:ImageButton=itemView.findViewById(R.id.expandableIcon)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycler_item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items=itemList[position]
        holder.heading.text=items.topicTittle
        holder.sections.text="${items.completed}/${items.sections} sections"

        holder.layout.visibility = if (items.IsExpandable) View.VISIBLE else View.GONE
        holder.itemView.setOnClickListener {
            items.IsExpandable=!items.IsExpandable
           notifyDataSetChanged()
        }


        holder.icon.setImageResource(if (items.IsExpandable) R.drawable.ic_baseline_expand_less_24 else R.drawable.ic_baseline_expand_more_24)
        setNewRecyclerView(items.subSections,holder.subRecyclerView,context)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }


    private fun setNewRecyclerView(
        listData: ArrayList<SubSectionItemList>,
        subRecyclerView: RecyclerView,
        context: Context
    ){
        val layoutManager=LinearLayoutManager(context)
        subRecyclerView.layoutManager=layoutManager
        val adapter=SubAdapter(listData)
        subRecyclerView.adapter=adapter
        adapter.notifyDataSetChanged()
    }

}