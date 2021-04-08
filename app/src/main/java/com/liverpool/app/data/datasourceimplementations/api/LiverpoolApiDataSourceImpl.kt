package com.liverpool.app.data.datasourceimplementations.api


import com.liverpool.app.data.exceptions.ApiResponseHandler
import com.liverpool.app.data.services.api.LiverpoolService
import com.liverpool.app.domain.datasourceabstractions.LiverpoolDataSource
import com.liverpool.app.domain.mappers.SearchMapper
import com.liverpool.app.domain.models.Search
import io.reactivex.Observable
import javax.inject.Inject

class LiverpoolApiDataSourceImpl @Inject constructor(
    private val liverpoolService: LiverpoolService,
    private val apiResponseHandler: ApiResponseHandler,
    private val searchMapper: SearchMapper
) : LiverpoolDataSource {

    override fun search(
        forcePlp: Boolean,
        searchString: String,
        pageNumber: Int,
        numberOfItemsPerPage: Int
    ): Observable<Search> =
        this.liverpoolService.search(forcePlp, searchString, pageNumber, numberOfItemsPerPage)
            .flatMap { response ->
                this.apiResponseHandler.handle(response)
            }.map { searchResponse ->
                searchMapper.mapFromApi(searchResponse)
            }
}