package com.oscargil80.todoapproomsqllitemvvm

object DataObject {

    var lisdata = mutableListOf<CardInfo>()

    init {

    }

    fun setData(title: String, priority: String) {
        lisdata.add(CardInfo(title, priority))
    }

    fun getAllData(): List<CardInfo> {
        return lisdata
    }

    fun deleteAll() {
        lisdata.clear()
    }

    fun getData(pos: Int): CardInfo {
        return lisdata[pos]
    }

    fun deleteData(pos: Int) {
        lisdata.removeAt(pos)
    }

    fun updateData(pos: Int, title: String, priotity: String) {
        lisdata[pos].title = title
        lisdata[pos].priority = priotity
    }


}