package com.example.rickandmortyexamweek2.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyexamweek2.data.EpisodeInfo
import com.example.rickandmortyexamweek2.databinding.FragmentRickAndMortyEpisodesBinding
import com.example.rickandmortyexamweek2.di.viewModel.RickAndMortyEpisodesViewModelFactory
import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import com.example.rickandmortyexamweek2.ui.adapter.AdapterListener
import com.example.rickandmortyexamweek2.ui.adapter.EpisodeAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RickAndMortyEpisodesFragment : DaggerFragment(), AdapterListener {

    private var _binding: FragmentRickAndMortyEpisodesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: RickAndMortyEpisodesViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[RickAndMortyEpisodesViewModel::class.java]
    }

    private var episodeAdapter: EpisodeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRickAndMortyEpisodesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observing()
        setRecyclerView()
        viewModel.fetchRickAndMortyEpisodes()
    }

    private fun observing() {
        viewModel.episodes.observe(viewLifecycleOwner) {
            when (it) {
                is RickAndMortyEpisodesResponse.Loading -> handleLoading()
                is RickAndMortyEpisodesResponse.Failure -> handleFailure()
                is RickAndMortyEpisodesResponse.Success -> handleSuccess(it)
            }
        }
    }

    private fun handleLoading() {
        Toast.makeText(context, LOADING_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun handleFailure() {
        Toast.makeText(context, ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun handleSuccess(rickAndMortyEpisodesResponse: RickAndMortyEpisodesResponse.Success) {
        episodeAdapter?.setEpisodes(rickAndMortyEpisodesResponse.episodes)
    }

    private fun setRecyclerView() {
        episodeAdapter = EpisodeAdapter(this)
        binding.episodeInfoRecyclerView.apply {
            adapter = episodeAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        episodeAdapter = null
    }

    override fun onEpisodeSelected(episodeInfo: EpisodeInfo) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(episodeInfo.url)
        startActivity(intent)
    }

    companion object {
        private const val ERROR_MESSAGE = "Error loading data, sorry"
        private const val LOADING_MESSAGE = "Loading episodes"
    }

}