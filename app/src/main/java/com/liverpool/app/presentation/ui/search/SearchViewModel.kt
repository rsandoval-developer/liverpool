package com.liverpool.app.presentation.ui.search

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.models.requestObjects.SearchRequest
import com.liverpool.app.domain.useCases.SearchUseCase
import com.liverpool.app.presentation.ui.viewmodels.base.ViewModelBase

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModelBase() {

    val searchViewModelState = MutableLiveData<SearchViewModelState>()

    fun search(
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ) {

        val searchRequest = SearchRequest(true, searchString, pageNumber, numberOfItemsPerPage)

        this.searchViewModelState.value = SearchViewModelState.ProgressVisibility(View.VISIBLE)
        this.searchUseCase.execute(
            params = searchRequest,
            onSuccess = ::handleSearch,
            onError = ::handleError
        )
    }

    private fun handleSearch(search: Search) {
        this.searchViewModelState.value = SearchViewModelState.ProgressVisibility(View.GONE)
        this.searchViewModelState.value = SearchViewModelState.SearchSucces(search.records)
    }


    override fun defaultError(error: Throwable) {
        this.searchViewModelState.value = SearchViewModelState.ProgressVisibility(View.GONE)
        this.searchViewModelState.value = SearchViewModelState.ErrorState(error.message ?: "")
    }

    override fun onCleared() {
        this.searchUseCase.dispose()
        super.onCleared()
    }
}