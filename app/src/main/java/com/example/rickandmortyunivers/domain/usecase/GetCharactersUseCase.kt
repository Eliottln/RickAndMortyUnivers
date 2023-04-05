package com.example.rickandmortyunivers.domain.usecase

import com.example.rickandmortyunivers.data.CharactersResponse
import com.example.rickandmortyunivers.data.repository.CharacterRepository

class GetCharactersUseCase {
    suspend operator fun invoke(page: Int): CharactersResponse? {
        return CharacterRepository.newInstance().getCharacters(page)
    }
}