package br.com.lucas.digidex.data

import br.com.lucas.digidex.R
import br.com.lucas.digidex.model.Digimon

object DataSource {
    val digimons: List<Digimon> = listOf(
        Digimon(1,"Koromon", R.drawable.koromon,0,2),
        Digimon(2,"Agumon", R.drawable.agumon,1,3),
        Digimon(3,"Greymon", R.drawable.greymon,2,0)
    )
}