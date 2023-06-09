package com.example.rickandmortyunivers.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("origin") val origin: LocationModel?,
    @SerializedName("location") val location: LocationModel?,
    @SerializedName("episode") val episode: ArrayList<String>?,
)
