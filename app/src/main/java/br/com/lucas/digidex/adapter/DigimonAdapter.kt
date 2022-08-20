package br.com.lucas.digidex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.lucas.digidex.R
import br.com.lucas.digidex.data.DataSource
import br.com.lucas.digidex.ui.DigimonListDirections

class DigimonAdapter: RecyclerView.Adapter<DigimonAdapter.DigimonViewHolder>() {

    private val listaDigimons = DataSource.digimons

    class DigimonViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.digimon_name_item)
        val img: ImageView = view.findViewById(R.id.img_digimon_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.digimon_item, parent, false)
        return DigimonViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DigimonViewHolder, position: Int) {
        val digimonItem = listaDigimons[position]
        holder.name.text = digimonItem.name
        holder.img.setImageResource(digimonItem.imgResource)
        holder.view.setOnClickListener{
            val action = DigimonListDirections.actionDigimonListToDigimonDetail(digimonItem.name, digimonItem.priorFormId, digimonItem.nextFormId)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = listaDigimons.size
}