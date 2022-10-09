package com.example.rickandmortyexamweek2.data

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") override var name: String? = null,
    @SerializedName("air_date") override var airDate: String? = null,
    @SerializedName("episode") override var episode: String? = null,
    @SerializedName("characters") var characters: List<String>,
    @SerializedName("url") override var url: String? = null,
    @SerializedName("created") var created: String? = null,
): EpisodeInfo
