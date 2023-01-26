package com.njagi.crypto.domain.repository

import com.njagi.crypto.data.remote.dto.CoinDetailDto
import com.njagi.crypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinDetails(coinId: String): CoinDetailDto
}
