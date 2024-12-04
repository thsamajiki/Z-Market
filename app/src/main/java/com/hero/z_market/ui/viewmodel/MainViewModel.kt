package com.hero.z_market.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.domain.usecase.FetchParentCategoryListUseCase
import com.hero.z_market.ui.state.UiEffect
import com.hero.z_market.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchParentCategoryListUseCase: FetchParentCategoryListUseCase,
) : ViewModel() {
    sealed class MainUiEvent {
        object FetchParentCategoryList : MainUiEvent()
        data class OnClickParentCategory(val parentCategory: ParentCategoryEntity) : MainUiEvent()
    }

    sealed class MainUiIntent {
        object LoadParentCategoryList : MainUiIntent()
        data class SelectParentCategory(val parentCategory: ParentCategoryEntity) : MainUiIntent()
    }

    private val _fetchParentCategoryListUiState = MutableStateFlow<UiState<List<ParentCategoryEntity>>>(UiState.Idle)
    val fetchParentCategoryListUiState: StateFlow<UiState<List<ParentCategoryEntity>>> = _fetchParentCategoryListUiState.asStateFlow()

    private val _parentCategoryUiEffect = Channel<UiEffect<ParentCategoryEntity>>(Channel.BUFFERED)
    val parentCategoryUiEffect = _parentCategoryUiEffect.receiveAsFlow()

    fun fetchParentCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                fetchParentCategoryListUseCase.invoke()
            }
                .onSuccess { parentCategoryList ->
                    _fetchParentCategoryListUiState.value = UiState.Success(parentCategoryList)
                }
                .onFailure {
                    _fetchParentCategoryListUiState.value = UiState.Failed("ParentCategoryList Failed")
                    sendParentCategoryUiEffect(UiEffect.ShowToast("데이터를 불러오는 데 실패했습니다."))
                    it.printStackTrace()
                }
        }
    }

    // 상태 갱신 로직을 Reducer로 처리
    private fun handleIntent(intent: MainUiIntent) {
        when (intent) {
            is MainUiIntent.LoadParentCategoryList -> fetchParentCategoryList()
            is MainUiIntent.SelectParentCategory -> {
                viewModelScope.launch {
                    _parentCategoryUiEffect.trySend(UiEffect.NavigateTo(intent.parentCategory))
                }
            }
        }
    }

    fun handleEvent(event: MainUiEvent) {
        when (event) {
            is MainUiEvent.FetchParentCategoryList -> handleIntent(MainUiIntent.LoadParentCategoryList)
            is MainUiEvent.OnClickParentCategory -> handleIntent(MainUiIntent.SelectParentCategory(event.parentCategory))
        }
    }

    fun sendParentCategoryUiEffect(effect: UiEffect<ParentCategoryEntity>) {
        viewModelScope.launch {
            _parentCategoryUiEffect.trySend(effect)
        }
    }
}
