package com.subhambikash.expandablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lm=LinearLayoutManager(this)
        recyclerView.layoutManager=lm
        val arrayList= arrayListOf<ListItemModel>()
        val subArrayList= arrayListOf<SubSectionItemList>()
        repeat(5){
            subArrayList.add(SubSectionItemList("how to install android studio",false))
        }

        repeat(20){
            arrayList.add(ListItemModel("Kotlin","5","3",subArrayList,false))
        }

        val adapter=RecyclerViewAdapter(this,arrayList)
        recyclerView.adapter=adapter
        adapter.notifyDataSetChanged()



    }




}