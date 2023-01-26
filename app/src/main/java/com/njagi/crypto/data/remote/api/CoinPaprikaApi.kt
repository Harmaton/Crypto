package com.njagi.crypto.data.remote.api

import com.njagi.crypto.data.remote.dto.CoinDetailDto
import com.njagi.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinbyId( @Path("coinId") coinId: String ): CoinDetailDto
}