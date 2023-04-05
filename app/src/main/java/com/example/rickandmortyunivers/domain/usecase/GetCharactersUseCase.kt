package com.example.rickandmortyunivers.domain.usecase

import com.example.rickandmortyunivers.data.model.CharactersResponseModel
import com.example.rickandmortyunivers.data.repository.CharacterRepository

class GetCharactersUseCase {
    suspend operator fun invoke(page: Int): CharactersResponseModel? {
        return CharacterRepository.newInstance().getCharacters(page)
    }
}