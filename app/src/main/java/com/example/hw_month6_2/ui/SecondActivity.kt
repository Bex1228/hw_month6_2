package com.example.hw_month6_2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.hw_month6_2.R
import com.example.hw_month6_2.data.RickAndMortyModel
import com.example.hw_month6_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiveData= intent.getSerializableExtra("characterModel") as RickAndMortyModel.Result
        with(binding){
            tvCharacterName.text = receiveData.name
            tvStatus.text = receiveData.status
            tvSpecies.text = receiveData.species
            tvLocationInfo.text = receiveData.location.name
            Glide.with(binding.imgCharacter).load(receiveData.image).into(binding.imgCharacter)
        }
    }
}