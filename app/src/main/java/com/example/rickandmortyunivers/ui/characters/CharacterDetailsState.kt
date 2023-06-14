package com.example.rickandmortyunivers.ui.characters

import com.example.rickandmortyunivers.data.model.CharacterModel

data class CharacterDetailsState(

    val isInProgress: Boolean,

    val currentError: Exception?,

    val successModel: CharacterModel?

)
