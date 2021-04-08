package com.liverpool.app.domain.datasourceabstractions

import com.liverpool.app.domain.models.Search
import io.reactivex.Observable

interface LiverpoolDataSource {

    fun search(
        forcePlp: Boolean,
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ): Observable<Search>
}