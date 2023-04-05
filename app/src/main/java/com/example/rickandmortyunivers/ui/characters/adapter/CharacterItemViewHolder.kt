package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyunivers.data.model.CharacterModel
import com.example.rickandmortyunivers.databinding.ItemTitleAndImageBinding

class CharacterItemViewHolder private constructor(
    private val binding: ItemTitleAndImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): CharacterItemViewHolder {
            return CharacterItemViewHolder(
                ItemTitleAndImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(characterModel: CharacterModel, onItemClicked: ((id: Int) -> Unit)) {
        binding.avatarIv.load(characterModel.image)
        binding.nameTv.text = characterModel.name
        binding.statusTv.text = characterModel.status
        binding.locationTv.text = characterModel.location?.name
        binding.originTv.text = characterModel.origin?.name
        binding.root.setOnClickListener {
            onItemClicked(characterModel.id)
        }
    }


}