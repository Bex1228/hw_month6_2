package com.example.hw_month6_2.ui.characters

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_month6_2.data.Resource
import com.example.hw_month6_2.databinding.ActivityCharacterBinding
import com.example.hw_month6_2.ui.adapter.CartoonAdapter
import com.example.hw_month6_2.ui.base.BaseActivity
import com.example.hw_month6_2.ui.characterDetails.CharacterDetailsActivity
import com.example.hw_month6_2.ui.utils.CartoonKeys
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterActivity : BaseActivity() {

    private lateinit var binding: ActivityCharacterBinding

    private val viewModel: CharacterViewModel by viewModel()

    private val cartoonAdapter by lazy { CartoonAdapter(this::onClickItem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupCharactersRecycler()

        viewModel.getCharacters().stateHandler(
            success = {
                cartoonAdapter.submitList(it)
            },
            state = { state ->
                binding.progressBar.isVisible = state is Resource.Loading
            }
        )
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