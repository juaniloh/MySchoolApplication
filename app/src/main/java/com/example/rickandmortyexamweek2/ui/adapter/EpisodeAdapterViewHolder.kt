package com.example.rickandmortyexamweek2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyexamweek2.data.EpisodeInfo
import com.example.rickandmortyexamweek2.databinding.EpisodeAdapterBinding

class EpisodeAdapterViewHolder(
    private val parent: ViewGroup,
    private val viewHolderListener: AdapterListener,
    private val binding: EpisodeAdapterBinding =
        EpisodeAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
): RecyclerView.ViewHolder(binding.root) {
    fun bindModelToView(episode: EpisodeInfo) {
        binding.nameTextView.text = episode.name
        binding.episodeTextView.text = episode.episode
        binding.airDateTextView.text = episode.airDate
        binding.root.setOnClickListener{
            viewHolderListener.onEpisodeSelected(episode)
        }
    }
}
