package com.example.meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.MyFeel
import com.example.meditation.MyState
import com.example.meditation.R
import com.example.meditation.databinding.FragmentHomeBinding
import com.example.meditation.recapters.FeelRecycler
import com.example.meditation.recapters.FeelRecycler2

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val feel_recycler : RecyclerView = root.findViewById(R.id.feel_rec)
        val state_recycler : RecyclerView = root.findViewById(R.id.feel_rec2)
        feel_recycler.adapter = FeelRecycler(requireContext(),MyFeel().list)
        state_recycler.adapter = FeelRecycler2(requireContext(),MyState().list)
        return root
    }
}