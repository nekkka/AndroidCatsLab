package com.example.kotiki.model.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.kotiki.model.entity.Kotik


class KotItemCallback : DiffUtil.ItemCallback<Kotik>() {

    override fun areItemsTheSame(oldItem: Kotik, newItem: Kotik): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Kotik, newItem: Kotik): Boolean {
        return oldItem.grooming == newItem.grooming && oldItem.max_weight == newItem.max_weight && oldItem.playfulness == newItem.playfulness
    }

}