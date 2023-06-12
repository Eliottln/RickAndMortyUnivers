package com.example.rickandmortyunivers.ui.characters

import com.example.rickandmortyunivers.data.model.EpisodeModel

data class CharacterEpisodeState(

    val isInProgress: Boolean,

    val currentError: Exception?,

    val successModel: List<EpisodeModel>?

)
