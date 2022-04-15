package com.subhambikash.expandablerecyclerview

data class ListItemModel(var topicTittle:String,var sections:String,var completed:String,var subSections:ArrayList<SubSectionItemList>,var IsExpandable:Boolean)