package com.example.rickandmortyunivers.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.domain.CharactersPagingSource
import com.example.rickandmortyunivers.service.ApiClient

abstract class CharactersListViewModel : ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        CharactersPagingSource(ApiClient.apiService)
    }.flow.cachedIn(viewModelScope)
    abstract val character: LiveData<CharacterModel>
    abstract fun getCharacterById()
}

class CharactersListViewModelImpl : CharactersListViewModel() {
    private val _character = MutableLiveData<CharacterModel>()
    override val character: LiveData<CharacterModel> = _character
    override fun getCharacterById() {
        //TODO get one character
    }

}