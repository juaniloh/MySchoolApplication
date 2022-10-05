package com.example.myapplication.module

import android.content.Context
//import android.content.SharedPreferences
import com.example.myapplication.api.Api
import com.example.myapplication.repository.school.SchoolSourceRepository
import com.example.myapplication.repository.school.SchoolSourceRepositoryContract

class AppComponent(
    context: Context,
    private val api: Api,
//    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
//        KEY_SHARED,
//        Context.MODE_PRIVATE
//    )
) {
    private val schoolSourceRepositoryContract: SchoolSourceRepositoryContract by lazy {
        SchoolSourceRepository(api)
    }

//    companion object {
//        private const val KEY_SHARED = "key:share_prefs"
//    }
}