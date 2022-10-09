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
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp
import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import com.example.rickandmortyexamweek2.retrofit.NetworkLibrary
import com.example.rickandmortyexamweek2.ui.adapter.AdapterListener
import com.example.rickandmortyexamweek2.ui.adapter.EpisodeAdapter

class RickAndMortyEpisodesFragment : Fragment(), AdapterListener {

    private var _binding: FragmentRickAndMortyEpisodesBinding? = null
    private val binding get() = _binding!!

    private val repository: RickAndMortyEpisodesRepository by lazy {
        RickAndMortyEpisodesRepositoryImp(
            NetworkLibrary.rickAndMortyAPI
        )
    }

    private val viewModel: RickAndMortyEpisodesViewModel by lazy {
        ViewModelProvider(
            this,
            RickAndMortyEpisodesViewModelFactory(repository)
        )[RickAndMortyEpisodesViewModel::class.java]
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
                is RickAndMortyEpisodesResponse.Failure -> handleFailure()
                is RickAndMortyEpisodesResponse.Success -> handleSuccess(it)
            }
        }
    }

    private fun handleFailure() {
        Toast.makeText(context, "Error loading data, sorry", Toast.LENGTH_SHORT).show()
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
    }

    override fun onEpisodeSelected(episodeInfo: EpisodeInfo) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(episodeInfo.url)
        startActivity(intent)
    }

}