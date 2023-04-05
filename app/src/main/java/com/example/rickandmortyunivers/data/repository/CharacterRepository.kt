package com.example.rickandmortyunivers.data.repository

import com.example.rickandmortyunivers.data.CharactersResponse
import com.example.rickandmortyunivers.service.ApiClient

interface CharacterRepository {
    suspend fun getCharacters(page:Int): CharactersResponse?

    companion object {
        fun newInstance(): CharacterRepository {
            return CharacterRepositoryImpl()
        }
    }
}

private class CharacterRepositoryImpl: CharacterRepository {

    private val service = ApiClient.apiService

    override suspend fun getCharacters(page: Int): CharactersResponse? {
        return service.getCharacters(page)
    }

}