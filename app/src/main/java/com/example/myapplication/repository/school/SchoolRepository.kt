package com.example.myapplication.repository.school

import androidx.annotation.GuardedBy
import com.example.myapplication.data.SchoolSimp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolRepository(
    private val schoolLocalRepository: SchoolLocalRepositoryContract,
    private val schoolSourceRepository: SchoolSourceRepositoryContract,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): SchoolRepositoryContract {

    @GuardedBy("this")
    @Volatile
    private var school:SchoolSimp? = null

    override fun setSelectedSchool(school: SchoolSimp?) = synchronized(this) {
        this.school = school
    }

    override fun getSelectedSchool(): SchoolSimp? = synchronized(this) {
        school
    }

    override fun cleanSelectedSchool() = synchronized(this) {
        school = null
    }

    override suspend fun fetchSchoolsFromSource(): List<SchoolSimp> = fetchSchoolsFromLocal().sortedBy {
        it.schoolName
    }

    private suspend fun fetchSchoolsFromLocal() = withContext(dispatcher) {
        val schools = schoolLocalRepository.fetchSchoolsFromSource()
        if (schools.isNotEmpty()) {
            return@withContext schools
        } else {
            schoolSourceRepository.fetchSchoolsFromSource().apply {
                if (this.isNotEmpty()) {
                    schoolLocalRepository.persistSchools(this)
                } else {
                    return@withContext this
                }
            }
        }
    }
}
