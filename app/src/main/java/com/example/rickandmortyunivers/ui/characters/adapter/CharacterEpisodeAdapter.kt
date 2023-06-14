package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyunivers.data.model.EpisodeModel

class CharacterEpisodeAdapter(val list: List<EpisodeModel>,
    private var onItemClicked: ((id: Int) -> Unit)
) : RecyclerView.Adapter<CharacterEpisodeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterEpisodeItemViewHolder {
        return CharacterEpisodeItemViewHolder.newInstance(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterEpisodeItemViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

}