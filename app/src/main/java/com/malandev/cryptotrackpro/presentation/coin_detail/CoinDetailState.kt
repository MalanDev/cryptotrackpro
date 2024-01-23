package com.malandev.cryptotrackpro.presentation.coin_detail

import com.malandev.cryptotrackpro.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading:Boolean = false,
    val coin:CoinDetail? = null,
    val error:String = ""
)