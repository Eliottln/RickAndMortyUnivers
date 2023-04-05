package com.example.rickandmortyunivers.ui.characters.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyunivers.data.model.CharacterModel

class CharactersAdapter(private var onItemClicked: ((id: Int) -> Unit)): RecyclerView.Adapter<CharacterItemViewHolder>() {

    var charactersList: ArrayList<CharacterModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
//        val binding = ItemTitleAndImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterItemViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bind(charactersList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}