package com.example.roomreferences.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomreferences.databinding.RvItemBinding
import com.example.roomreferences.db.MyCard

class MyRvAdapter(var list: List<MyCard>) : RecyclerView.Adapter<MyRvAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding):RecyclerView.ViewHolder(rvItemBinding.root){
        fun onBind(myCard: MyCard, position: Int ){
            rvItemBinding.tvName.text = myCard.name
            rvItemBinding.tvNumber.text = myCard.number.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}