package com.njagi.crypto.presentation.coin_detail

import com.njagi.crypto.domain.model.Coin
import com.njagi.crypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)