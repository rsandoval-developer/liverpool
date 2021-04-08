package com.liverpool.app.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.liverpool.app.domain.useCases.SearchUseCase
import javax.inject.Inject

class SearchViewModelFactory @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(
                SearchUseCase::class.java
            )
            .newInstance(
                this.searchUseCase
            )
    }
}