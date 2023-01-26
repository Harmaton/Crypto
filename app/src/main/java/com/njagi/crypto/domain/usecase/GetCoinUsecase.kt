package com.njagi.crypto.domain.usecase

import com.njagi.crypto.common.Resource
import com.njagi.crypto.data.remote.dto.toCoinDetail
import com.njagi.crypto.domain.model.CoinDetail
import com.njagi.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repo : CoinRepository){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coin = repo.getCoinDetails(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch(e: IOException){
            emit(Resource.Error("Check your Internet"))
        }
    }
}