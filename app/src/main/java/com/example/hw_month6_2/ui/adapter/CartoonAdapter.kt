package com.example.hw_month6_2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_month6_2.R
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.databinding.ItemCartoonBinding
import com.example.hw_month6_2.ui.utils.Indicator

class CartoonAdapter(
    private val onClick: (characterId: Int) -> Unit,
) : androidx.recyclerview.widget.ListAdapter<Character, CartoonAdapter.CartoonViewHolder>(
    CartoonDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CartoonViewHolder(
        ItemCartoonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), onClick
    )

    override fun onBindViewHolder(holder: CartoonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CartoonViewHolder(
        private val binding: ItemCartoonBinding,
        private val onClick: (characterId: Int) -> Unit
    ) : ViewHolder(binding.root) {
        fun bind(model: Character) = with(binding) {
            tvCharacterName.text = model.name
            tvExistence.text = model.status
            tvSpecies.text = model.species
            tvLocationInfo.text = model.location.name
            Glide.with(imgCharacter).load(model.image).into(imgCharacter)
            itemView.setOnClickListener { onClick(model.id) }

            when (tvExistence.text.toString().uppercase()) {
                Indicator.ALIVE.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_alive)
                Indicator.UNKNOWN.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_unknown)
                Indicator.DEAD.toString() -> imgIndicator.setBackgroundResource(R.drawable.indicator_dead)
            }
        }
    }
}

class CartoonDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.id == newItem.id
}