package com.example.rickandmortyunivers.data.repository

import com.example.rickandmortyunivers.data.model.CharactersResponseModel
import com.example.rickandmortyunivers.service.ApiClient

interface CharacterRepository {
    suspend fun getCharacters(page:Int): CharactersResponseModel?

    companion object {
        fun newInstance(): CharacterRepository {
            return CharacterRepositoryImpl()
        }
    }
}

private class CharacterRepositoryImpl: CharacterRepository {

    private val service = ApiClient.apiService

    override suspend fun getCharacters(page: Int): CharactersResponseModel? {
        return service.getCharacters(page)
    }

}