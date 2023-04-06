package com.example.rickandmortyunivers.data.repository

import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.service.ApiClient

interface CharacterRepository {
    suspend fun getCharacterById(id:Int): CharacterModel?

    companion object {
        fun newInstance(): CharacterRepository {
            return CharacterRepositoryImpl()
        }
    }
}

private class CharacterRepositoryImpl: CharacterRepository {

    private val service = ApiClient.apiService

    override suspend fun getCharacterById(id: Int): CharacterModel? {
        return service.getCharacterById(id)
    }

}