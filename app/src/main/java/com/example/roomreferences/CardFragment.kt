package com.example.roomreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.roomreferences.Adapters.MyRvAdapter
import com.example.roomreferences.databinding.FragmentCardBinding
import com.example.roomreferences.db.AppDatabase
import com.example.roomreferences.db.MyCard

class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding
    private lateinit var list: ArrayList<MyCard>
    private lateinit var appDatabase: AppDatabase
    private lateinit var myRvAdapter: MyRvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(layoutInflater)

        list = ArrayList()

        appDatabase = AppDatabase.getInstance(binding.root.context)

        list.addAll(appDatabase.userDao().getCards())

        myRvAdapter = MyRvAdapter(list)
        binding.rvCard.adapter = myRvAdapter


        binding.btnSave.setOnClickListener {

            val myCard = MyCard(binding.edtCard.text.toString(), binding.edtNumber.text.toString().toLong())
            appDatabase.userDao().addCards(myCard)
            list.add(myCard)
            myRvAdapter.notifyItemInserted(list.size-1)
        }






        return binding.root
    }
}