package com.liverpool.app.domain.repositoryabstractions

import com.liverpool.app.domain.models.Search
import io.reactivex.Observable

interface LiverpoolRepository {

    fun search(
        forcePlp: Boolean,
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ): Observable<Search>
}