package com.njagi.crypto.presentation.coin_list

import com.njagi.crypto.domain.model.Coin

data class CoinListState (

    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)