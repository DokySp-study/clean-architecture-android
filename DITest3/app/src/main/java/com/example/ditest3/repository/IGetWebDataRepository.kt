package com.example.ditest3.repository

import com.example.ditest3.domain.WebData

interface IGetWebDataRepository {
    fun getWebDataByUrl(url: String): WebData
}