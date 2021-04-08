package com.liverpool.app.domain.models

data class Search(
    val records: List<Record>
)

data class Record(
    val productDisplayName: String,
    val minimumListPrice: Double,
    val maximumListPrice: Double,
    val productAvgRating: Double,
    val productRatingCount: Int,
    val xlImage: String
)
