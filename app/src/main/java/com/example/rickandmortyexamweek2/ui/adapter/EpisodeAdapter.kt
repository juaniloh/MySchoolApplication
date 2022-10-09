package com.example.rickandmortyexamweek2.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyexamweek2.data.EpisodeInfo

class EpisodeAdapter(
    private val adapterListener: AdapterListener,
    ): RecyclerView.Adapter<EpisodeAdapterViewHolder>(), AdapterListener{

    private val episodes = mutableListOf<EpisodeInfo>()

    fun setEpisodes(newEpisodes: List<EpisodeInfo>) {
        episodes.addAll(newEpisodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeAdapterViewHolder =
        EpisodeAdapterViewHolder(parent, this)

    override fun onBindViewHolder(holder: EpisodeAdapterViewHolder, position: Int) {
        holder.bindModelToView(episodes[position])
    }

    override fun getItemCount(): Int = episodes.size

    override fun onEpisodeSelected(episodeInfo: EpisodeInfo) {
        adapterListener.onEpisodeSelected(episodeInfo)
    }
}