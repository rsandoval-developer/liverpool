package com.liverpool.app.data.services.api

import com.liverpool.app.AppConstants
import com.liverpool.app.domain.models.responseObjects.SearchResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LiverpoolService {

    @GET(AppConstants.API_SEARCH)
    fun search(
        @Query("force-plp") forcePlp: Boolean,
        @Query("search-string") searchString: String,
        @Query("page-number") pageNumber: Int,
        @Query("number-of-items-per-page") numberOfItemsPerPage: Int
    ): Observable<Response<SearchResponse>>
}