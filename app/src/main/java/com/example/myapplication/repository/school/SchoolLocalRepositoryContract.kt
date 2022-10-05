package com.example.myapplication.repository.school

import com.example.myapplication.data.SchoolSimp

interface SchoolLocalRepositoryContract: SchoolSourceRepositoryContract {
    suspend fun persistSchools(schools: List<SchoolSimp>)

    suspend fun addSchool(school: SchoolSimp)
}