package br.com.lucas.digidex.model

import androidx.annotation.DrawableRes

data class Digimon(
    private val id: Int,
    private val name:String,
    @DrawableRes private val imgResource: Int,
    private val priorFormId: Int,
    private val nextFormId: Int
)