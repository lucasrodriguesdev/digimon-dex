package br.com.lucas.digidex.model

import androidx.annotation.DrawableRes

data class Digimon(
    val id: Int,
    val name:String,
    @DrawableRes val imgResource: Int,
    val priorFormId: Int,
    val nextFormId: Int
)