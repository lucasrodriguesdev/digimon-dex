package br.com.lucas.digidex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lucas.digidex.R
import br.com.lucas.digidex.adapter.DigimonAdapter
import br.com.lucas.digidex.databinding.FragmentDigimonListBinding

class DigimonList : Fragment() {

    private var _binding: FragmentDigimonListBinding? =null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDigimonListBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerviewDigimonList
        recyclerView.adapter = DigimonAdapter()

        return binding.root
    }

}