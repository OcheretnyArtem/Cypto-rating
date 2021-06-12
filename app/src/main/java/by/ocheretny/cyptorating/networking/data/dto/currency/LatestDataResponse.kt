package by.ocheretny.cyptorating.networking.data.dto.currency


import com.google.gson.annotations.SerializedName

data class LatestDataResponse(
    @SerializedName("data")
    val `data`: Map<String, Data>?,
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
        @SerializedName("is_active")
        val isActive: Number?,
        @SerializedName("is_fiat")
        val isFiat: Number?,
        @SerializedName("is_market_cap_included_in_calc")
        val isMarketCapIncludedInCalc: Number?,
        @SerializedName("last_updated")
        val lastUpdated: String?,
        @SerializedName("max_supply")
        val maxSupply: Number?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("num_market_pairs")
        val numMarketPairs: Number?,
        @SerializedName("platform")
        val platform: String?,
        @SerializedName("quote")
        val quote: Map<String, Quote>?,
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
        val timestamp: String?
    )
}