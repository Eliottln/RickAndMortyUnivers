package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyunivers.data.model.EpisodeModel
import com.example.rickandmortyunivers.databinding.ItemCharacterEpisodeBinding

class CharacterEpisodeItemViewHolder private constructor(
    private val binding: ItemCharacterEpisodeBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): CharacterEpisodeItemViewHolder {
            return CharacterEpisodeItemViewHolder(
                ItemCharacterEpisodeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(episodeModel: EpisodeModel?, onItemClicked: ((id: Int) -> Unit)) {
        episodeModel?.let {
            binding.epNameTv.text = it.name
            binding.episodeTv.text = it.episode
//            binding.root.setOnClickListener {
//                onItemClicked()
//            }
        }
    }


}