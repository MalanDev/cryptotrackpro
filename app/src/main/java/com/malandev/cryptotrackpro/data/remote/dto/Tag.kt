package com.malandev.cryptotrackpro.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("coin_counter")
    val coinCounter: Int, // 10
    @SerializedName("ico_counter")
    val icoCounter: Int, // 0
    val id: String, // segwit
    val name: String // Segwit
)