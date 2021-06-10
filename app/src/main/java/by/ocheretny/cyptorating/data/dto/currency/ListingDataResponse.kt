package com.uogames.longProject.HW8.data.dto.currency


import com.google.gson.annotations.SerializedName

data class ListingDataResponse(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("status")
    val status: Status?
) {
    data class Data(
        @SerializedName("circulating_supply")
        val circulatingSupply: Number?,
        @SerializedName("cmc_rank")
        val cmcRank: Number?,
        @SerializedName("date_added")
        val dateAdded: String?,
        @SerializedName("id")
        val id: Number?,
        @SerializedName("last_updated")
        val lastUpdated: String?,
        @SerializedName("max_supply")
        val maxSupply: Number?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("num_market_pairs")
        val numMarketPairs: Number?,
        @SerializedName("platform")
        val platform: Any?,
        @SerializedName("quote")
        val quote: Quote?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("symbol")
        val symbol: String?,
        @SerializedName("tags")
        val tags: List<String?>?,
        @SerializedName("total_supply")
        val totalSupply: Number?
    ) {
        data class Quote(
            @SerializedName("USD")
            val uSD: USD?
        ) {
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Number?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Number?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Number?,
                @SerializedName("percent_change_30d")
                val percentChange30d: Number?,
                @SerializedName("percent_change_60d")
                val percentChange60d: Number?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Number?,
                @SerializedName("percent_change_90d")
                val percentChange90d: Number?,
                @SerializedName("price")
                val price: Number?,
                @SerializedName("volume_24h")
                val volume24h: Number?
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        val creditCount: Number?,
        @SerializedName("elapsed")
        val elapsed: Number?,
        @SerializedName("error_code")
        val errorCode: Number?,
        @SerializedName("error_message")
        val errorMessage: Any?,
        @SerializedName("notice")
        val notice: Any?,
        @SerializedName("timestamp")
        val timestamp: String?,
        @SerializedName("total_count")
        val totalCount: Number?
    )
}