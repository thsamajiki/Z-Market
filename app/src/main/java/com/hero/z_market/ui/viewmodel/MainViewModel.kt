package com.hero.z_market.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.domain.usecase.FetchParentCategoryListUseCase
import com.hero.z_market.ui.state.UiState
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
    private val _fetchParentCategoryListUiState = MutableStateFlow<UiState<List<ParentCategoryModel>>>(UiState.Idle)
    val fetchParentCategoryListUiState: StateFlow<UiState<List<ParentCategoryModel>>> = _fetchParentCategoryListUiState.asStateFlow()

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
                    it.printStackTrace()
                }
        }
    }
}
