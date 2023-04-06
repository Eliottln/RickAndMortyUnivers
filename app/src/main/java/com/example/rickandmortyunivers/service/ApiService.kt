package com.example.rickandmortyunivers.service

import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.data.model.ApiResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page : Int): ApiResponseModel<CharacterModel>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id : Int): CharacterModel?

}