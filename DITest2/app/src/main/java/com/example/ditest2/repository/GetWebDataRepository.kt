package com.example.ditest2.repository

import com.example.ditest2.domain.WebData

class GetWebDataRepository {

    private val TAG = "[Repository]"

    fun getWebDataByUrl(url: String): WebData {

        var webData = WebData(
            url = url,
            header = "metadata=content-header;",
            body = "<html>hello world!</html>",
            status = 200
        )

        return webData
    }

}