package com.malandev.cryptotrackpro.domain.repository

import com.malandev.cryptotrackpro.data.remote.dto.CoinDetailDto
import com.malandev.cryptotrackpro.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String):CoinDetailDto
}