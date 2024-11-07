package com.hero.z_market.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.domain.usecase.FetchParentCategoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchParentCategoryListUseCase: FetchParentCategoryListUseCase,
) : ViewModel() {
    sealed class UiState {
        data class FetchParentCategoryListSuccess(
            val value: List<ParentCategoryModel>
        ): UiState()

        data class FetchParentCategoryListFailed(
            val message: String
        ): UiState()

        object Idle : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchParentCategoryList()
    }

    fun fetchParentCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                fetchParentCategoryListUseCase.invoke()
            }
                .onSuccess { parentCategoryList ->
                    _uiState.value = UiState.FetchParentCategoryListSuccess(parentCategoryList)
                }
                .onFailure {
                    _uiState.value = UiState.FetchParentCategoryListFailed("ParentCategoryList Failed")
                    it.printStackTrace()
                }
        }
    }
}
