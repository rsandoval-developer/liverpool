package com.liverpool.app.data.reposotoryImplementations

import com.liverpool.app.domain.dataSourceAbstractions.LiverpoolDataSource
import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.repositoryAbstractions.LiverpoolRepository
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