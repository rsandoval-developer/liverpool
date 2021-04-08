package com.liverpool.app.domain.models.responseObjects

import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @field:SerializedName("pageType")
    val pageType: String? = null,

    @field:SerializedName("plpResults")
    val plpResults: PlpResults,

    @field:SerializedName("status")
    val status: Status? = null
)

data class Navigation(

    @field:SerializedName("current")
    val current: List<CurrentItem>? = null,

    @field:SerializedName("ancester")
    val ancester: List<AncesterItem>? = null,

    @field:SerializedName("childs")
    val childs: List<Any?>? = null
)

data class AncesterItem(

    @field:SerializedName("label")
    val label: String? = null,

    @field:SerializedName("categoryId")
    val categoryId: String? = null
)

data class PlpFlagsItem(

    @field:SerializedName("flagId")
    val flagId: String? = null,

    @field:SerializedName("flagMessage")
    val flagMessage: String? = null
)

data class VariantsColorItem(

    @field:SerializedName("colorName")
    val colorName: String? = null,

    @field:SerializedName("colorImageURL")
    val colorImageURL: String? = null,

    @field:SerializedName("colorHex")
    val colorHex: String? = null
)

data class PlpState(

    @field:SerializedName("lastRecNum")
    val lastRecNum: Int? = null,

    @field:SerializedName("totalNumRecs")
    val totalNumRecs: Int? = null,

    @field:SerializedName("firstRecNum")
    val firstRecNum: Int? = null,

    @field:SerializedName("currentSortOption")
    val currentSortOption: String? = null,

    @field:SerializedName("categoryId")
    val categoryId: String? = null,

    @field:SerializedName("recsPerPage")
    val recsPerPage: Int? = null,

    @field:SerializedName("currentFilters")
    val currentFilters: String? = null,

    @field:SerializedName("originalSearchTerm")
    val originalSearchTerm: String? = null
)

data class RefinementItem(

    @field:SerializedName("refinementId")
    val refinementId: String? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("label")
    val label: String? = null,

    @field:SerializedName("selected")
    val selected: Boolean? = null
)

data class Status(

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("statusCode")
    val statusCode: Int? = null
)

data class SortOptionsItem(

    @field:SerializedName("sortBy")
    val sortBy: String? = null,

    @field:SerializedName("label")
    val label: String? = null
)

data class RecordsItem(

    @field:SerializedName("isMarketPlace")
    val isMarketPlace: Boolean? = null,

    @field:SerializedName("seller")
    val seller: String? = null,

    @field:SerializedName("maximumListPrice")
    val maximumListPrice: Double? = null,

    @field:SerializedName("groupType")
    val groupType: String? = null,

    @field:SerializedName("smImage")
    val smImage: String? = null,

    @field:SerializedName("maximumPromoPrice")
    val maximumPromoPrice: Double? = null,

    @field:SerializedName("isImportationProduct")
    val isImportationProduct: Boolean? = null,

    @field:SerializedName("brand")
    val brand: String? = null,

    @field:SerializedName("productType")
    val productType: String? = null,

    @field:SerializedName("marketplaceSLMessage")
    val marketplaceSLMessage: String? = null,

    @field:SerializedName("plpFlags")
    val plpFlags: List<Any?>? = null,

    @field:SerializedName("productId")
    val productId: String? = null,

    @field:SerializedName("minimumListPrice")
    val minimumListPrice: Double? = null,

    @field:SerializedName("xlImage")
    val xlImage: String? = null,

    @field:SerializedName("skuRepositoryId")
    val skuRepositoryId: String? = null,

    @field:SerializedName("productAvgRating")
    val productAvgRating: Double? = null,

    @field:SerializedName("marketplaceBTMessage")
    val marketplaceBTMessage: String? = null,

    @field:SerializedName("promoPrice")
    val promoPrice: Double? = null,

    @field:SerializedName("minimumPromoPrice")
    val minimumPromoPrice: Double? = null,

    @field:SerializedName("productDisplayName")
    val productDisplayName: String? = null,

    @field:SerializedName("productRatingCount")
    val productRatingCount: Int? = null,

    @field:SerializedName("isHybrid")
    val isHybrid: Boolean? = null,

    @field:SerializedName("variantsColor")
    val variantsColor: List<VariantsColorItem>? = null,

    @field:SerializedName("lgImage")
    val lgImage: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("listPrice")
    val listPrice: Double? = null
)

data class RefinementGroupsItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("refinement")
    val refinement: List<RefinementItem?>? = null,

    @field:SerializedName("dimensionName")
    val dimensionName: String? = null,

    @field:SerializedName("multiSelect")
    val multiSelect: Boolean? = null
)

data class CurrentItem(

    @field:SerializedName("label")
    val label: String? = null,

    @field:SerializedName("categoryId")
    val categoryId: String? = null
)

data class PlpResults(

    @field:SerializedName("refinementGroups")
    val refinementGroups: List<RefinementGroupsItem>? = null,

    @field:SerializedName("navigation")
    val navigation: Navigation? = null,

    @field:SerializedName("sortOptions")
    val sortOptions: List<SortOptionsItem>? = null,

    @field:SerializedName("records")
    val _records: List<RecordsItem>? = null,

    @field:SerializedName("plpState")
    val plpState: PlpState? = null,

    @field:SerializedName("label")
    val label: String? = null
) {
    val records: List<RecordsItem>
        get() = this._records ?: emptyList()
}
