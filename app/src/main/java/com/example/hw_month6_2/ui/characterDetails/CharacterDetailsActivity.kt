package com.example.hw_month6_2.ui.characterDetails

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.hw_month6_2.R
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.databinding.ActivityCharacterDetailsBinding
import com.example.hw_month6_2.ui.base.BaseActivity
import com.example.hw_month6_2.ui.utils.CartoonKeys
import com.example.hw_month6_2.ui.utils.Indicator
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsActivity : BaseActivity() {
    private lateinit var binding: ActivityCharacterDetailsBinding
    private val viewModel by viewModel<CharacterDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activityId = intent.getIntExtra(CartoonKeys.CHARACTER_ID_ARG, 0)

        viewModel.getCharacterDetails(activityId).stateHandler(
            success = {
                setupCharacterData(it)
            }
        )
    }

    private fun setupCharacterData(receiveData: Character) {
        binding.apply {
            tvCharacterName.text = receiveData.name
            tvStatus.text = receiveData.status
            tvSpecies.text = receiveData.species
            tvLocationInfo.text = receiveData.location.name
            Glide.with(imgCharacter).load(receiveData.image).into(imgCharacter)
            when (tvStatus.text.toString().uppercase()) {
                Indicator.ALIVE.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_alive)
                Indicator.UNKNOWN.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_unknown)
                Indicator.DEAD.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_dead)
            }
        }
    }
}