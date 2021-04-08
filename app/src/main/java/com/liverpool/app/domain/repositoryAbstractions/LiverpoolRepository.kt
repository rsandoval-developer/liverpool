package com.liverpool.app.domain.repositoryAbstractions

import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.models.responseObjects.SearchResponse
import io.reactivex.Observable

interface LiverpoolRepository {

    fun search(
        forcePlp: Boolean,
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ): Observable<Search>
}