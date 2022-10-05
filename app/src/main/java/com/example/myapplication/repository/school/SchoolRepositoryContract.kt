package com.example.myapplication.repository.school

import com.example.myapplication.data.SchoolSimp

interface SchoolRepositoryContract: SchoolSourceRepositoryContract {
    fun setSelectedSchool(school: SchoolSimp?)

    fun getSelectedSchool(): SchoolSimp?

    fun  cleanSelectedSchool()
}