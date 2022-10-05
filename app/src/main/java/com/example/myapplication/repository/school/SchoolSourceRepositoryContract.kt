package com.example.myapplication.repository.school

import com.example.myapplication.data.SchoolSimp

interface SchoolSourceRepositoryContract {
    suspend fun fetchSchoolsFromSource(): List<SchoolSimp>
}
