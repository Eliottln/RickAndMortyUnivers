package com.example.rickandmortyunivers.ui.characters

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyunivers.databinding.FragmentCharactersListBinding
import com.example.rickandmortyunivers.domain.CharacterComparator
import com.example.rickandmortyunivers.ui.characters.adapter.CharactersAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharactersListFragment : Fragment() {

    private lateinit var viewModel: CharactersListViewModel
    private lateinit var binding: FragmentCharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharactersListViewModelImpl::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharactersAdapter(CharacterComparator) {
            val intent = Intent(requireContext(), CharacterDetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }

}