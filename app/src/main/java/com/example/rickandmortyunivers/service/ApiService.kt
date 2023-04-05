package com.example.rickandmortyunivers.service

import com.example.rickandmortyunivers.data.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page : Int): CharactersResponse?

}