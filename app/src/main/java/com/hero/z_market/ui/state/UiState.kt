package com.hero.z_market.ui.state

sealed class UiState<out T>(val _data: T?) {
    data class Success<out R>(val data: R) : UiState<R>(_data = data)
    data class Failed(val message: String) : UiState<Nothing>(null)
    object Idle : UiState<Nothing>(_data = null)
}
