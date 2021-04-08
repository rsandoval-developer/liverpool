package com.liverpool.app.domain.usecases

import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.models.requestObjects.SearchRequest
import com.liverpool.app.domain.repositoryabstractions.LiverpoolRepository
import com.liverpool.app.domain.usecases.base.ParamsUseCase
import io.reactivex.Observable
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val liverpoolRepository: LiverpoolRepository
) :
    ParamsUseCase<Search, SearchRequest>() {

    override fun createObservable(params: SearchRequest): Observable<Search> =
        this.liverpoolRepository.search(
            params.forcePlp,
            params.searchString,
            params.pageNumber,
            params.numberOfItemsPerPage
        )
}