package com.example.rickandmortyunivers.domain.usecase

import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.data.repository.CharacterRepository

class GetCharacterByIdUseCase {
    suspend operator fun invoke(id: Int): CharacterModel? {
        return CharacterRepository.newInstance().getCharacterById(id)
    }
}