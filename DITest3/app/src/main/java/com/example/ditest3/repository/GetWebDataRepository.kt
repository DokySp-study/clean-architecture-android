package com.example.ditest3.repository

import com.example.ditest3.domain.WebData

class GetWebDataRepository: IGetWebDataRepository {

    private val TAG = "[Repository]"

    override fun getWebDataByUrl(url: String): WebData {

        var webData = WebData(
            url = url,
            header = "metadata=content-header;",
            body = "<html>hello world!</html>",
            status = 200
        )

        return webData
    }

}