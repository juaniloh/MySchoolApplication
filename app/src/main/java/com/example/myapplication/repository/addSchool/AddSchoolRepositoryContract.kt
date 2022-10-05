package com.example.myapplication.repository.addSchool

import com.example.myapplication.data.SchoolSimp

interface AddSchoolRepositoryContract {
    suspend fun addNewSchoolToLocal(school: SchoolSimp)
}