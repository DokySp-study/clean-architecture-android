package com.example.ditest1.viewmodel

import com.example.ditest1.domain.WebData
import com.example.ditest1.service.GetWebDataService

class MainViewModel {

    private val TAG = "[ViewModel]"
    private val service = GetWebDataService()

    var body: String = ""
        private set
    var message: String = ""
        private set
    var status: Int = 0
        private set
    var isError: Boolean = false
        private set

    fun getWebData() {
        val data = service.getWebDataByUrl("https://www.example.com")
        body = data.body
        status = data.status

        if(data.status < 400) {
            isError = false
            message = "Okay"
        } else if (data.status in 400..499) {
            isError = true
            message = "Connection Error"
        } else if (data.status in 500..599) {
            isError = true
            message = "Server Error"
        } else  {
            isError = true
            message = "Unknown Error"
        }
    }
}