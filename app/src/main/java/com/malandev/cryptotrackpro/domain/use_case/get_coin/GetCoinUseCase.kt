package com.malandev.cryptotrackpro.domain.use_case.get_coin

import com.malandev.cryptotrackpro.common.Resources
import com.malandev.cryptotrackpro.data.remote.dto.toCoinDetail
import com.malandev.cryptotrackpro.domain.model.CoinDetail
import com.malandev.cryptotrackpro.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) = flow <Resources<CoinDetail>>{
        try {
            emit(Resources.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resources.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resources.Error<CoinDetail>(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e:IOException){
            emit(Resources.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}