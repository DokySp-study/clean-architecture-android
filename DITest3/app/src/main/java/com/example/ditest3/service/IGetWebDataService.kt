package com.example.ditest3.service

import com.example.ditest3.domain.WebData

interface IGetWebDataService {
    fun getWebDataByUrl(url: String): WebData
}