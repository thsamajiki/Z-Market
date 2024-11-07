package com.hero.z_market.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.domain.model.ChildCategoryModel
import com.hero.z_market.domain.model.GoodsModel
import com.hero.z_market.domain.usecase.FetchChildCategoryListUseCase
import com.hero.z_market.domain.usecase.FetchGoodsUseCase
import com.hero.z_market.domain.usecase.FetchPaginationInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChildCategoryGoodsListViewModel @Inject constructor(
    private val fetchChildCategoryListUseCase: FetchChildCategoryListUseCase,
    private val fetchGoodsUseCase: FetchGoodsUseCase,
    private val fetchPaginationInfoUseCase: FetchPaginationInfoUseCase,
) : ViewModel() {
    private val _childCategoryList = MutableStateFlow<List<ChildCategoryModel>>(emptyList())
    val childCategoryList: StateFlow<List<ChildCategoryModel>>
        get() = _childCategoryList

    private val _goods = MutableStateFlow<PagingData<GoodsModel>>(PagingData.empty())
    val goods: StateFlow<PagingData<GoodsModel>> get() = _goods

    private val _paginationInfo = MutableStateFlow(PaginationItem())
    val paginationInfo = _paginationInfo.asStateFlow()

    //대분류
    private val _parentCategorySeq = MutableStateFlow<Int>(0)
    val parentCategorySeq: StateFlow<Int> = _parentCategorySeq

    //중분류
    private val _childCategorySeq = MutableStateFlow<Int>(0)
    val childCategorySeq: StateFlow<Int> = _childCategorySeq

    //소분류
    private val _sortValue = MutableStateFlow<String>(GoodsSort.RECOMMENDED.value)
    val sortValue: StateFlow<String> = _sortValue

    private val _selectedChildCategory = MutableStateFlow<ChildCategoryModel>(
        ChildCategoryModel(
            _childCategorySeq.value,
            "상품 전체",
            _parentCategorySeq.value,
            "",
            "",
            true
        )
    )
    val selectedChildCategory: StateFlow<ChildCategoryModel>
        get() = _selectedChildCategory

    init {
        observeSelectedDataChanges()
    }

    private fun observeSelectedDataChanges() {
        viewModelScope.launch(Dispatchers.IO) {
            combine(
                parentCategorySeq,
                childCategorySeq,
                sortValue
            ) { parentSeq, childSeq, option ->
                Triple(parentSeq, childSeq, option)
            }.collect { (parentSeq, childSeq, option) ->
                fetchGoodsList(parentSeq, childSeq, 0, 20, option)
            }
        }
    }

    // 대분류 변경하는 함수
    fun setParentCategorySeqValue(parentCategorySeq: Int?) {
        _parentCategorySeq.value = parentCategorySeq ?: 0
    }

    // 중분류 변경하는 함수
    fun setChildCategorySeqValue(childCategorySeq: Int) {
        _childCategorySeq.value = childCategorySeq
    }

    // 정렬 순을 변경하는 함수
    fun setSortValue(value: String) {
        _sortValue.value = value
    }

    fun fetchChildCategoryList(parentCategorySeq: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchChildCategoryListUseCase.invoke(parentCategorySeq)
                .collectLatest { childCategory ->
                    _childCategoryList.value = childCategory
                }
        }
    }

    fun fetchGoodsList(parentCategorySeq: Int,
                       childCategorySeq: Int,
                       page: Int,
                       size: Int,
                       query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchGoodsUseCase.invoke(parentCategorySeq, childCategorySeq, page, size, query)
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _goods.value = pagingData
                }
        }
    }

    fun fetchPaginationInfo(parentCategorySeq: Int,
                            childCategorySeq: Int,
                            page: Int,
                            size: Int,
                            query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchPaginationInfoUseCase.invoke(parentCategorySeq, childCategorySeq, page, size, query)
                .collectLatest { pagination ->
                _paginationInfo.value = pagination
            }
        }
    }
}
