package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyunivers.data.Character
import com.example.rickandmortyunivers.databinding.ItemTitleAndImageBinding

class CharactersAdapter(private var onItemClicked: ((id: Int) -> Unit)): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var charactersList: ArrayList<Character> = arrayListOf()

    inner class ViewHolder(private val binding: ItemTitleAndImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) = binding.apply {
            binding.nameTv.text = character.name
            binding.statusTv.text = character.status
            root.setOnClickListener {
                onItemClicked(character.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTitleAndImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}