package com.example.rickandmortyunivers.ui.characters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyunivers.data.Character
import com.example.rickandmortyunivers.databinding.FragmentCharactersListBinding
import com.example.rickandmortyunivers.ui.characters.adapter.CharactersAdapter

class CharactersListFragment : Fragment() {

    private lateinit var viewModel: CharactersListViewModel
    private lateinit var binding: FragmentCharactersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CharactersListViewModelImpl::class.java]

        viewModel.getCharacters()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(inflater, container, false)

        val adapter = CharactersAdapter {

        }
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        viewModel.charactersList.observe(viewLifecycleOwner) {
            adapter.charactersList = it as ArrayList<Character>
        }
        return binding.root
    }

}