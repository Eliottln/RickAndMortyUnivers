package com.example.rickandmortyunivers.service

import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.data.model.CharactersResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page : Int): CharactersResponseModel

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id : Int): CharacterModel?

}