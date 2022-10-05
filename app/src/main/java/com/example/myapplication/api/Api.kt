package com.example.myapplication.api

import com.example.myapplication.data.SchoolSimp
import retrofit2.http.GET

interface Api {
    @GET("s3k6-pzi2.json")
    suspend fun getSchool(): List<SchoolSimp>
}