package com.example.rickandmortyunivers.data

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<Character>?
)
