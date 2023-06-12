package com.example.rickandmortyunivers.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyunivers.domain.CharactersPagingSource
import com.example.rickandmortyunivers.domain.usecase.GetCharacterByIdUseCase
import com.example.rickandmortyunivers.domain.usecase.GetEpisodesListByIdUseCase
import com.example.rickandmortyunivers.service.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class CharactersListViewModel() : ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        CharactersPagingSource(ApiClient.apiService)
    }.flow.cachedIn(viewModelScope)
    abstract fun getCharacterById(id: Int)
    abstract fun getEpisodeListById(idList: String)
}

class CharactersListViewModelImpl() : CharactersListViewModel() {

    private val _state = MutableStateFlow(
        CharacterDetailsState(
            isInProgress = true,
            currentError = null,
            successModel = null
        )
    )

    val state: StateFlow<CharacterDetailsState>
        get() = _state.asStateFlow()

    private val _episodeState = MutableStateFlow(
        CharacterEpisodeState(
            isInProgress = true,
            currentError = null,
            successModel = null
        )
    )

    val episodeState: StateFlow<CharacterEpisodeState>
        get() = _episodeState.asStateFlow()

    override fun getCharacterById(id: Int) {
        viewModelScope.launch {
            _state.emit(
                CharacterDetailsState(
                    isInProgress = true,
                    currentError = null,
                    successModel = null
                )
            )
            _state.emit(
                try {
                    CharacterDetailsState(
                        isInProgress = false,
                        currentError = null,
                        successModel = GetCharacterByIdUseCase().invoke(id)
                    )
                } catch (e: Exception) {
                    CharacterDetailsState(
                        isInProgress = false,
                        currentError = e,
                        successModel = null
                    )
                }
            )
        }
    }

    override fun getEpisodeListById(idList: String) {
        viewModelScope.launch {
            _episodeState.emit(
                CharacterEpisodeState(
                    isInProgress = true,
                    currentError = null,
                    successModel = null
                )
            )
            _episodeState.emit(
                try {
                    CharacterEpisodeState(
                        isInProgress = false,
                        currentError = null,
                        successModel = GetEpisodesListByIdUseCase().invoke(idList)
                    )
                } catch (e: Exception) {
                    CharacterEpisodeState(
                        isInProgress = false,
                        currentError = e,
                        successModel = null
                    )
                }
            )
        }
    }


}