package com.example.myapplication.module

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.api.Api
import com.example.myapplication.repository.addSchool.AddSchoolRepository
import com.example.myapplication.repository.addSchool.AddSchoolRepositoryContract
import com.example.myapplication.repository.school.*

class AppComponent(
    context: Context,
    private val api: Api,
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        KEY_SHARED,
        Context.MODE_PRIVATE
    )
) {
    private val schoolSourceRepositoryContract: SchoolSourceRepositoryContract by lazy {
        SchoolSourceRepository(api)
    }

    private val schoolLocalRepositoryContract: SchoolLocalRepositoryContract by lazy {
        SchoolLocalRepository(sharedPreferences)
    }

    val schoolRepositoryContract : SchoolRepositoryContract by lazy {
        SchoolRepository(schoolLocalRepositoryContract, schoolSourceRepositoryContract)
    }

    val addSchoolRepositoryContract: AddSchoolRepositoryContract by lazy {
        AddSchoolRepository(schoolLocalRepositoryContract)
    }

    companion object {
        private const val KEY_SHARED = "key:share_prefs"
    }
}