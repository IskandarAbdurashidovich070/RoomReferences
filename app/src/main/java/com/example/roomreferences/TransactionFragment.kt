package com.example.roomreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.roomreferences.Adapters.MyTransactionAdapter
import com.example.roomreferences.databinding.FragmentTransactionBinding
import com.example.roomreferences.db.AppDatabase
import com.example.roomreferences.db.MyCard
import com.example.roomreferences.db.MyTransaction


class TransactionFragment : Fragment() {
    private lateinit var binding: FragmentTransactionBinding
    private lateinit var myCardList: ArrayList<MyCard>
    private lateinit var myCardNameList: ArrayList<String>
    private lateinit var appDatabase: AppDatabase
    private lateinit var list: ArrayList<MyTransaction>
    private lateinit var myTransactionAdapter: MyTransactionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionBinding.inflate(layoutInflater)

        appDatabase = AppDatabase.getInstance(binding.root.context)


        loadCard()
        setTransaction()
        showTransaction()


        return binding.root
    }

    private fun showTransaction() {
        list = ArrayList()
        list.addAll(appDatabase.userDao().getTransaction())
        myTransactionAdapter = MyTransactionAdapter(list, appDatabase)
        binding.rvCard.adapter = myTransactionAdapter
    }

    private fun setTransaction() {
        binding.btnSave.setOnClickListener {
            val myTransaction = MyTransaction(
                myCardList[binding.fromCard.selectedItemPosition].id,
                myCardList[binding.toCard.selectedItemPosition].id,
                binding.edtNumber.text.toString()
            )
            appDatabase.userDao().addTransaction(myTransaction)
            showTransaction()
        }
    }

    private fun loadCard() {
        myCardList = ArrayList()
        myCardList.addAll(appDatabase.userDao().getCards())
        myCardNameList = ArrayList()

        myCardList.forEach {
            myCardNameList.add(it.name!!)
        }
        val adapter = ArrayAdapter<String>(
            binding.root.context,
            android.R.layout.simple_list_item_1,
            myCardNameList
        )

        binding.fromCard.adapter = adapter
        binding.toCard.adapter = adapter
    }


}