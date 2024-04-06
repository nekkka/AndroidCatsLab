package com.example.kotiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotiki.databinding.ItemKotikBinding
import com.example.kotiki.model.entity.Kotik
import com.example.kotiki.model.diff_util.KotItemCallback

class KotikListAdapter : ListAdapter<Kotik, KotikListAdapter.ViewHolder>(KotItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKotikBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemKotikBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Kotik) {
            with(binding) {
                Glide.with(root.context)
                    .load(cat.img)
                    .into(catImage)

                catName.text = cat.name
                catMxWeight.text = cat.max_weight.toString()
                catMxLife.text = cat.max_life_expectancy.toString()


            }
        }
    }
}
