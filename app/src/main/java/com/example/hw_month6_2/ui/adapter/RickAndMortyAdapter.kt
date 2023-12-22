package com.example.hw_month6_2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_month6_2.data.RickAndMortyModel
import com.example.hw_month6_2.databinding.ItemCartoonBinding

class RickAndMortyAdapter(
    private val onClick: (cartoonModel: RickAndMortyModel.Result) -> Unit,
    private val list: List<RickAndMortyModel.Result>
) :
    Adapter<RickAndMortyAdapter.CartoonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartoonViewHolder {
        return CartoonViewHolder(
            ItemCartoonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CartoonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CartoonViewHolder(private val binding: ItemCartoonBinding) :
        ViewHolder(binding.root) {
        fun bind(cartoon: RickAndMortyModel.Result) {
            Glide.with(binding.imgCharacter).load(cartoon.image).into(binding.imgCharacter)
            binding.tvCharacterName.text = cartoon.name
            binding.tvStatus.text = cartoon.status
            binding.tvSpecies.text = cartoon.species
            binding.tvLocationInfo.text = cartoon.location.name
            itemView.setOnClickListener { onClick(cartoon) }
        }
    }
}