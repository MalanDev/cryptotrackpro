package com.malandev.cryptotrackpro.data.repository

import com.malandev.cryptotrackpro.data.remote.CoinPaprikaApi
import com.malandev.cryptotrackpro.data.remote.dto.CoinDetailDto
import com.malandev.cryptotrackpro.data.remote.dto.CoinDto
import com.malandev.cryptotrackpro.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoins();
    }
    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}