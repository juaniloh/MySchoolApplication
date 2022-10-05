package com.example.myapplication.repository.school

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.myapplication.data.SchoolSimp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolLocalRepository(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson = Gson(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : SchoolLocalRepositoryContract {

    private val typeToken by lazy {
        object : TypeToken<List<SchoolSimp?>?>() {}.type
    }

    override suspend fun persistSchools(schools: List<SchoolSimp>) {
        withContext(dispatcher) {
            val schoolsJson = gson.toJson(schools)
            sharedPreferences.edit {
                putString(KEY_SCHOOLS, schoolsJson)
                apply()
            }
        }
    }

    override suspend fun addSchool(school: SchoolSimp) {
        withContext(dispatcher) {
            val school = getSchoolsFromLocal()
        }
    }

    override suspend fun fetchSchoolFromSource(): List<SchoolSimp> =
        try {
            getSchoolsFromLocal()
        } catch (e: Throwable) {
            e.printStackTrace()
            emptyList()
        }

    private suspend fun getSchoolsFromLocal(): List<SchoolSimp> = withContext(dispatcher) {
        val schoolsFromJson = sharedPreferences.getString(KEY_SCHOOLS, "")
        if (schoolsFromJson.isNullOrEmpty()) {
            return@withContext emptyList<SchoolSimp>()
        } else {
            return@withContext gson.fromJson(schoolsFromJson, typeToken)
        }
    }

    companion object {
        private const val KEY_SCHOOLS = "key:schools"
    }
}
