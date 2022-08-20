package br.com.lucas.digidex.ui

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.lucas.digidex.R
import br.com.lucas.digidex.data.DataSource
import br.com.lucas.digidex.databinding.FragmentDigimonDetailBinding
import br.com.lucas.digidex.model.Digimon

class DigimonDetail : Fragment() {

    private var _binding: FragmentDigimonDetailBinding? =null
    private val binding get() = _binding!!
    private lateinit var nameDigimon: String
    private  var preEvolutionId: Int = 0
    private  var postEvolutionId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nameDigimon = it.getString("digimon_name").toString()
            preEvolutionId = it.getInt("pre")
            postEvolutionId = it.getInt("post")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDigimonDetailBinding.inflate(inflater, container,false)
        buscaDetalhe()
        return binding.root
    }

    private fun buscaDetalhe(){
        val preDigimon: List<Digimon> = DataSource.digimons.filter { it.id==preEvolutionId }
        val postDigimon: List<Digimon> = DataSource.digimons.filter { it.id==postEvolutionId }
        val actualDigimon: List<Digimon> = DataSource.digimons.filter { it.name==nameDigimon }
        binding.digimonNameDetail.text = nameDigimon
        binding.imgDigimonDetail.setImageResource(actualDigimon.first().imgResource)

        if(preDigimon.isNotEmpty()) {
            binding.digimonNamePreDetail.text = preDigimon.first().name
            binding.imgDigimonPre.setImageResource(preDigimon.first().imgResource)
        }

        if(postDigimon.isNotEmpty()) {
            binding.digimonNameProDetail.text = postDigimon.first().name
            binding.imgDigimonPro.setImageResource(postDigimon.first().imgResource)
        }

    }

}