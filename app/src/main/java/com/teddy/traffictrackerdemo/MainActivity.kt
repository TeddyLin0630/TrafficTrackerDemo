package com.teddy.traffictrackerdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.teddy.traffictrackerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MockioViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.progress.observe(this, Observer { binding.progress.isVisible = it })

        viewModel.gettingValue.observe(this, Observer { binding.response.text = it })

        binding.fetchButton.setOnClickListener {
            binding.response.text = ""
            viewModel.get()
        }
    }
}
