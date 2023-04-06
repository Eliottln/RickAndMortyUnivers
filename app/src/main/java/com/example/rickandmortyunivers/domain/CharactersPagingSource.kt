package com.example.rickandmortyunivers.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.service.ApiService

class CharactersPagingSource(
    private val api: ApiService,
) : PagingSource<Int, CharacterModel>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterModel> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = api.getCharacters(nextPageNumber)
            val data = response.results
            val responseData = mutableListOf<CharacterModel>()
            responseData.addAll(data)
            return LoadResult.Page(
                data = responseData,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
