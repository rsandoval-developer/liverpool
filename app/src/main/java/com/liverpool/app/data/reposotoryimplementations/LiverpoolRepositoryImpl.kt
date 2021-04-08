package com.liverpool.app.data.reposotoryimplementations

import com.liverpool.app.domain.datasourceabstractions.LiverpoolDataSource
import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.repositoryabstractions.LiverpoolRepository
import io.reactivex.Observable
import javax.inject.Inject

class LiverpoolRepositoryImpl @Inject constructor(private val liverpoolDataSource: LiverpoolDataSource) :
    LiverpoolRepository {

    override fun search(
        forcePlp: Boolean,
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ): Observable<Search> =
        this.liverpoolDataSource.search(forcePlp, searchString, pageNumber, numberOfItemsPerPage)
}