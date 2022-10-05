package com.example.myapplication.repository.school

import com.example.myapplication.api.Api
import com.example.myapplication.data.SchoolSimp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolSourceRepository(
    private val api: Api,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ): SchoolSourceRepositoryContract {
        override suspend fun fetchSchoolFromSource(): List<SchoolSimp> =
            withContext(dispatcher) {
                api.getSchool()
            }
}
