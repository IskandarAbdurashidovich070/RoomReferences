package com.example.roomreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomreferences.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        binding.btnCards.setOnClickListener {
            findNavController().navigate(R.id.cardFragment)
        }

        binding.btnTransactions.setOnClickListener {
            findNavController().navigate(R.id.transactionFragment)
        }

        return binding.root
    }
}