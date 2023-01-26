package com.njagi.crypto.data.repository

import com.njagi.crypto.data.remote.api.CoinPaprikaApi
import com.njagi.crypto.data.remote.dto.CoinDetailDto
import com.njagi.crypto.data.remote.dto.CoinDto
import com.njagi.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: CoinPaprikaApi ) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
      return  api.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailDto {
        return api.getCoinbyId(coinId)
    }

}