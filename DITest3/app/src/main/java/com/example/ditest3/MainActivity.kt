package com.example.ditest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.ditest3.databinding.ActivityMainBinding
import com.example.ditest3.repository.GetWebDataRepository
import com.example.ditest3.service.GetWebDataService
import com.example.ditest3.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "[Activity]"

    private lateinit var binding: ActivityMainBinding
    private var viewmodel = MainViewModel(GetWebDataService(GetWebDataRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }

    fun onClickGetData(view: View) {
        viewmodel.getWebData()

        binding.lblStatus.text = """
            [${viewmodel.status}] ${viewmodel.message}
        """.trimIndent()
        binding.lblBody.text = viewmodel.body
    }
}