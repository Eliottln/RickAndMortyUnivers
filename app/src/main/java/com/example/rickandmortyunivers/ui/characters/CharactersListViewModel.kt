package com.example.rickandmortyunivers.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.data.repository.CharacterRepository
import com.example.rickandmortyunivers.domain.CharactersPagingSource
import com.example.rickandmortyunivers.domain.usecase.GetCharactersUseCase
import com.example.rickandmortyunivers.service.ApiClient
import com.example.rickandmortyunivers.service.ApiService
import kotlinx.coroutines.launch

abstract class CharactersListViewModel : ViewModel() {
    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        CharactersPagingSource(ApiClient.apiService)
    }.flow.cachedIn(viewModelScope)

    abstract val charactersList: LiveData<List<CharacterModel>>
    abstract fun getCharacters()
}

class CharactersListViewModelImpl : CharactersListViewModel() {
    private val _charactersList = MutableLiveData<List<CharacterModel>>()
    override val charactersList: LiveData<List<CharacterModel>> = _charactersList
    override fun getCharacters() {
//        viewModelScope.launch {
//            GetCharactersUseCase().invoke(1).let { response ->
//                response?.results.let {
//                    _charactersList.postValue(it)
//                }
//            }
//        }
    }

}