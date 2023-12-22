package com.example.hw_month6_2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hw_month6_2.data.RickAndMortyModel
import com.example.hw_month6_2.databinding.ActivityMainBinding
import com.example.hw_month6_2.ui.adapter.RickAndMortyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLiveCartoon().observe(this){
            val adapter = RickAndMortyAdapter(this::onClickItem,it.results)
            binding.recyclerView.adapter=adapter
        }
    }
    private fun onClickItem(model: RickAndMortyModel.Result){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("characterModel",model)
        startActivity(intent)
    }
}
