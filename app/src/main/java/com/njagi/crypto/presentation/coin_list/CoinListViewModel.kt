package com.njagi.crypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.crypto.common.Resource
import com.njagi.crypto.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor( val coinsUseCase: GetCoinsUseCase): ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init{
        getCoins()
    }

    private fun getCoins(){
        coinsUseCase().onEach { result ->
            when(result) {
                is  Resource.Success -> {

                    _state.value = CoinListState(coins = result.data ?: emptyList() )

                }
                is  Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected Error Occurred"
                    )
                }
                is  Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}