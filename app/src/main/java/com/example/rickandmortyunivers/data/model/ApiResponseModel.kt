package com.example.rickandmortyunivers.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponseModel<T>(
    @SerializedName("info") val info: InfoModel,
    @SerializedName("results") val results: List<T>
)
