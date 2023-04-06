package com.example.rickandmortyunivers.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.data.model.CharactersResponseModel
import com.example.rickandmortyunivers.domain.CharactersPagingSource
import com.example.rickandmortyunivers.service.ApiClient
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(page:Int): Flow<PagingData<CharacterModel>>

    companion object {
        fun newInstance(): CharacterRepository {
            return CharacterRepositoryImpl()
        }
    }
}

private class CharacterRepositoryImpl: CharacterRepository {

    private val service = ApiClient.apiService

    override fun getCharacters(page: Int): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharactersPagingSource(service) }
        ).flow
        //return service.getCharacters(page)
    }

}