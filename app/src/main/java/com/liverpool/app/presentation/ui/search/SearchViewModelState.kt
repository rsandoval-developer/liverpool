package com.liverpool.app.presentation.ui.search

import com.liverpool.app.domain.models.Record

sealed class SearchViewModelState {

    data class ProgressVisibility(val visibility: Int) : SearchViewModelState()

    data class SearchSucces(val search: List<Record>) : SearchViewModelState()

    data class ErrorState(val error: String) : SearchViewModelState()
}