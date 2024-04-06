package com.example.kotiki.model.entity

import com.google.gson.annotations.SerializedName

data class Kotik (

    val name: String,
    @SerializedName("image_link") val img: String,
    val max_weight: Int,
    val max_life_expectancy : Int,
    @SerializedName("playfulness") val playfulness: Int,
    @SerializedName("grooming") val grooming: Int

)