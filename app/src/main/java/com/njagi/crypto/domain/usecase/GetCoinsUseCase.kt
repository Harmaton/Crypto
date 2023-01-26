package com.njagi.crypto.domain.usecase

import com.njagi.crypto.common.Resource
import com.njagi.crypto.data.remote.dto.toCoin
import com.njagi.crypto.domain.model.Coin
import com.njagi.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repo : CoinRepository){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repo.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }
        catch(e: HttpException){
           emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch(e: IOException){
            emit(Resource.Error("Check your Internet"))
        }
    }

}