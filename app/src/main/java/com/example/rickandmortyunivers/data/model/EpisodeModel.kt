package com.example.rickandmortyunivers.data.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val date: String,
    @SerializedName("episode") val episode: String
)
