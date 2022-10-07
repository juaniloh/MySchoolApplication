package com.example.rickandmortyexamweek2.data

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("info") var info: Info?,
    @SerializedName("results") var results: List<Results>,
)
