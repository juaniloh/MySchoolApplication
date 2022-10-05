package com.example.myapplication.repository.addSchool

import com.example.myapplication.data.SchoolSimp
import com.example.myapplication.repository.school.SchoolLocalRepository
import com.example.myapplication.repository.school.SchoolLocalRepositoryContract

class AddSchoolRepository(
    private val schoolLocalRepositoryContract: SchoolLocalRepositoryContract,
): AddSchoolRepositoryContract {
    override suspend fun addNewSchoolToLocal(school: SchoolSimp) {
        schoolLocalRepositoryContract.addSchool(school)
    }
}