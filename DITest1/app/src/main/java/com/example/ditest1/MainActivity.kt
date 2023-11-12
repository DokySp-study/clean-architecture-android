package com.example.ditest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.ditest1.databinding.ActivityMainBinding
import com.example.ditest1.repository.GetWebDataRepository
import com.example.ditest1.service.GetWebDataService
import com.example.ditest1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "[Activity]"

    lateinit var binding: ActivityMainBinding
    var viewmodel = MainViewModel()

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