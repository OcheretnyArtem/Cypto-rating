package com.uogames.longProject.HW8.data.entities.currency

data class ListingData(
    val `data`: List<Data>?
) {
    data class Data(
        val circulatingSupply: Number?,
        val cmcRank: Number?,
        val dateAdded: String?,
        val id: Number?,
        val lastUpdated: String?,
        val maxSupply: Number?,
        val name: String?,
        val numMarketPairs: Number?,
        val platform: Any?,
        val quote: Map<String, Quote>?,
        val slug: String?,
        val symbol: String?,
        val tags: List<String?>?,
        val totalSupply: Number?
    ) {
        data class Quote(
            val lastUpdated: String?,
            val marketCap: Number?,
            val percentChange1h: Number?,
            val percentChange24h: Number?,
            val percentChange30d: Number?,
            val percentChange60d: Number?,
            val percentChange7d: Number?,
            val percentChange90d: Number?,
            val price: Number?,
            val volume24h: Number?
        )
    }
}
