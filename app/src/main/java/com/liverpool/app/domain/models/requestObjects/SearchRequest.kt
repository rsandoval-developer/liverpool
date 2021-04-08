package com.liverpool.app.domain.models.requestObjects

data class SearchRequest(
    val forcePlp: Boolean,
    val searchString: String,
    val pageNumber: Int,
    val numberOfItemsPerPage: Int
)