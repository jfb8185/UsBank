package com.example.usbank.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.usbank.R
import com.example.usbank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NumberViewModel
    private val numberAdapter by lazy {
        NumberAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[NumberViewModel::class.java]

        binding.sparkView.adapter = numberAdapter
        viewModel.numbers.observe(this) { nums ->
            numberAdapter.submitList(nums)
        }
    }
}