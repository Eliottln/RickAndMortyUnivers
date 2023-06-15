package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyunivers.data.model.CharacterModel

class CharactersAdapter(
    diffCallback: DiffUtil.ItemCallback<CharacterModel>,
    private var onItemClicked: ((id: Int) -> Unit)
) : PagingDataAdapter<CharacterModel, CharacterItemViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        return CharacterItemViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClicked)
    }

}