package com.example.hw_month6_2.ui.characters

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_month6_2.data.Resource
import com.example.hw_month6_2.databinding.ActivityCharacterBinding
import com.example.hw_month6_2.ui.adapter.CartoonAdapter
import com.example.hw_month6_2.ui.characterDetails.CharacterDetailsActivity
import com.example.hw_month6_2.ui.utils.CartoonKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding

    private val viewModel: CharacterViewModel by viewModels()

    private val cartoonAdapter by lazy { CartoonAdapter(this::onClickItem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCharacters().observe(this) {result->
            when(result){
                is Resource.Error -> {
                    Toast.makeText(this,result.message,Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Success -> {
                    cartoonAdapter.submitList(result.data)
                    binding.progressBar.isVisible = false
                }
            }
            setupCharactersRecycler()
        }
    }

    private fun setupCharactersRecycler() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(
            this@CharacterActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = cartoonAdapter
    }

    private fun onClickItem(characterId: Int) {
        val intent = Intent(this, CharacterDetailsActivity::class.java)
        intent.putExtra(CartoonKeys.CHARACTER_ID_ARG, characterId)
        startActivity(intent)
    }
}