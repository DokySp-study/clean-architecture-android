package com.example.ditest1.service

import android.util.Log
import com.example.ditest1.domain.WebData
import com.example.ditest1.repository.GetWebDataRepository

class GetWebDataService {

    private val TAG = "[Service]"
    private val repository = GetWebDataRepository()

    fun getWebDataByUrl(url: String): WebData {

        val data = repository.getWebDataByUrl(url)
        Log.i(TAG, "get data")
        Log.i(TAG, data.toString())

        if(data.status < 400) {
            return WebData(
                body = data.body,
                header = data.header,
                url = data.url,
                status = data.status,
            )
        } else if (data.status in 400..499) {
            return WebData(
                body = "Connection Error",
                header = data.header,
                url = data.url,
                status = data.status,
            )
        } else if (data.status in 500..599) {
            return WebData(
                body = "Server Error",
                header = data.header,
                url = data.url,
                status = data.status,
            )
        } else  {
            return WebData(
                body = "Unknown Error",
                header = data.header,
                url = data.url,
                status = data.status,
            )
        }
    }
}