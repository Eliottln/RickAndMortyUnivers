package com.example.rickandmortyunivers.domain.usecase

import com.example.rickandmortyunivers.data.model.EpisodeModel
import com.example.rickandmortyunivers.data.repository.CharacterRepository

class GetEpisodesListByIdUseCase {

    suspend operator fun invoke(idList: String): List<EpisodeModel>? {
        return CharacterRepository.newInstance().getEpisodesListById(idList)
    }
}