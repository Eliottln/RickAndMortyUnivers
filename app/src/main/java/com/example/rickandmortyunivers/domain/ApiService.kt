package com.example.rickandmortyunivers.domain

import com.example.rickandmortyunivers.data.CharactersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

}