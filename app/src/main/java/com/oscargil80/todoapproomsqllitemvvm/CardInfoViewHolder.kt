package com.oscargil80.todoapproomsqllitemvvm

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.todoapproomsqllitemvvm.databinding.ViewBinding

class CardInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

private  var binding = ViewBinding.bind(view)

    fun render(
        CardInfo: CardInfo/*,
        onClickListener: (CardInfo) -> Unit,
        onItemSeleted: (Int) -> Unit,*/
    ) {
        binding.title.text = CardInfo.title
        binding.priority.text = CardInfo.priority

        var card: CardView = binding.CARD


        when (CardInfo.priority.toLowerCase()){
            "high"->     binding.CARD.setCardBackgroundColor(Color.parseColor("#f05454"))
            "mediun"->binding.CARD.setCardBackgroundColor(Color.parseColor("#EDC988"))
            else -> binding.CARD.setCardBackgroundColor(Color.parseColor("#00917C"))
        }

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, UpdateCard::class.java)
            intent.putExtra("id", adapterPosition)
            itemView.context.startActivity(intent)


            //onItemSeleted(adapterPosition)
        }
    }
}