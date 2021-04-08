package com.liverpool.app.domain.mappers

import com.liverpool.app.domain.models.Record
import com.liverpool.app.domain.models.Search
import com.liverpool.app.domain.models.responseObjects.RecordsItem
import com.liverpool.app.domain.models.responseObjects.SearchResponse
import javax.inject.Inject

class SearchMapper @Inject constructor() {

    fun mapFromApi(searchResponse: SearchResponse): Search =
        Search(
            searchResponse.plpResults.records
                .map { recordsItem ->
                    records(recordsItem)
                }
                .toList()
        )


    fun records(recordsItem: RecordsItem): Record =
        Record(
            recordsItem.productDisplayName ?: "",
            recordsItem.minimumListPrice ?: 0.0,
            recordsItem.maximumListPrice ?: 0.0,
            recordsItem.productAvgRating ?: 0.0,
            recordsItem.productRatingCount ?: 0,
            recordsItem.xlImage ?: ""
        )


}