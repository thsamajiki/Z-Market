package com.hero.z_market.ui.state

sealed class UiEffect<out T>(val _data: T?) {
    data class ShowToast(val message: String) : UiEffect<Nothing>(null)
    data class NavigateTo<out R>(val data: R) : UiEffect<R>(_data = data)
}
