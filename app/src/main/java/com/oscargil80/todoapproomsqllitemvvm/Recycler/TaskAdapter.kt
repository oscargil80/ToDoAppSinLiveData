package com.oscargil80.todoapproomsqllitemvvm.Recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.todoapproomsqllitemvvm.CardInfo
import com.oscargil80.todoapproomsqllitemvvm.R


class TaskAdapter(
    var CardInfoList: List<CardInfo>//,
//    val onClickListener: (CardInfo) -> Unit,
//    val onItemSeleted: (Int) -> Unit,
) : RecyclerView.Adapter<CardInfoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardInfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CardInfoViewHolder(layoutInflater.inflate(R.layout.view, parent, false))
    }

    override fun onBindViewHolder(holder: CardInfoViewHolder, position: Int) {
        val item = CardInfoList[position]
        holder.render(item)//, onClickListener, onItemSeleted)

    }

    override fun getItemCount(): Int = CardInfoList.size
}
