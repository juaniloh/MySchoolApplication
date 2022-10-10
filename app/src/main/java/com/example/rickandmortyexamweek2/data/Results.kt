package com.example.rickandmortyexamweek2.data

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") override var name: String? = null,
    @SerializedName("air_date") override var airDate: String? = null,
    @SerializedName("episode") override var episode: String? = null,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("url") override var url: String? = null,
    @SerializedName("created") val created: String? = null,
): EpisodeInfo
