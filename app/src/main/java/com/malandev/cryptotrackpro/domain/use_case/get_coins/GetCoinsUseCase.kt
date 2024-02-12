package com.malandev.cryptotrackpro.domain.use_case.get_coins

import com.malandev.cryptotrackpro.common.Resources
import com.malandev.cryptotrackpro.data.remote.dto.toCoin
import com.malandev.cryptotrackpro.domain.model.Coin
import com.malandev.cryptotrackpro.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() = flow <Resources<List<Coin>>>{
        try {
            emit(Resources.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resources.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resources.Error<List<Coin>>(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e:IOException){
            emit(Resources.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}