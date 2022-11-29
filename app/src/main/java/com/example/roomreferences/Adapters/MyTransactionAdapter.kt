package com.example.roomreferences.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomreferences.databinding.RvItem1Binding
import com.example.roomreferences.db.AppDatabase
import com.example.roomreferences.db.MyTransaction

class MyTransactionAdapter(var list: List<MyTransaction>, var appDatabase: AppDatabase) : RecyclerView.Adapter<MyTransactionAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItem1Binding):RecyclerView.ViewHolder(rvItemBinding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(user: MyTransaction, position: Int ){
            rvItemBinding.tvName.text = appDatabase.userDao().getCardById(user.fromCardId!!).name
            rvItemBinding.tvNumber.text = appDatabase.userDao().getCardById(user.toCardID!!).name
            rvItemBinding.tvPrice.text = user.summa + "so'm"
            rvItemBinding.tvDate.text = user.date
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItem1Binding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}