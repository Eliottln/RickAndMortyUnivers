package com.example.rickandmortyunivers.domain.usecase

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyunivers.data.model.CharacterModel

object CharacterComparator : DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        // Id is unique.
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }
}