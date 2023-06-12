package com.example.rickandmortyunivers.ui.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.rickandmortyunivers.R
import com.example.rickandmortyunivers.databinding.ActivityCharacterDetailBinding
import com.example.rickandmortyunivers.ui.characters.adapter.CharacterEpisodeAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersListViewModel
    private lateinit var binding: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CharactersListViewModelImpl::class.java]

        setContentView(binding.root)

        val id = intent.getIntExtra("id", 1)

        lifecycleScope.launch {
            (viewModel as CharactersListViewModelImpl).state.collectLatest { state ->

                state.currentError?.let {

                }

                state.successModel?.let {
                    binding.titleName.text = it.name
                    binding.avatarIv.load(it.image)
                    binding.statusTv.text = it.status
                    if (it.status == "Dead")
                        binding.viewAlive.background = ContextCompat.getDrawable(applicationContext, R.drawable.red_color)
                    binding.locationTv.text = it.location?.name
                    binding.originTv.text = it.origin?.name
                    it.episode?.let { episode ->
                        var episodes = ""
                        episode.forEachIndexed forEachIndexed@{ index, stringUrl ->
                            val number = stringUrl.split("/").last()
                            episodes = episodes.plus("$number,")
                            if (index > 18) {
                                return@forEachIndexed // not working
                            }
                        }
                        viewModel.getEpisodeListById(episodes)
                    }
                }
            }
        }

        lifecycleScope.launch {
            (viewModel as CharactersListViewModelImpl).episodeState.collectLatest { state ->

                state.currentError?.let {

                }

                state.successModel?.let {
                    val adapter = CharacterEpisodeAdapter(it){

                    }

                    binding.episodesRv.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                    binding.episodesRv.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
        }
        viewModel.getCharacterById(id)
    }

}