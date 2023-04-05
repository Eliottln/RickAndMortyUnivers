package com.example.rickandmortyunivers.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyunivers.data.Character
import com.example.rickandmortyunivers.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.launch

abstract class CharactersListViewModel : ViewModel() {
    abstract val charactersList: LiveData<List<Character>>
    abstract fun getCharacters()
}

class CharactersListViewModelImpl : CharactersListViewModel() {
    private val _charactersList = MutableLiveData<List<Character>>()
    override val charactersList: LiveData<List<Character>> = _charactersList
    override fun getCharacters() {
        viewModelScope.launch {
            GetCharactersUseCase().invoke(1).let { response ->
                response?.results.let {
                    _charactersList.postValue(it)
                }
            }
        }
    }

}