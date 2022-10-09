package com.example.rickandmortyexamweek2.ui.adapter

import com.example.rickandmortyexamweek2.data.EpisodeInfo

interface AdapterListener {
    fun onEpisodeSelected(episodeInfo: EpisodeInfo)
}