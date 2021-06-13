package by.ocheretny.cyptorating.networking.data.entities.currency

class LatestData(
    val `data`: Map<String, Data>?,
    val status: Status?
) {
    data class Data(
        val circulatingSupply: Number?,
        val cmcRank: Number?,
        val dateAdded: String?,
        val id: Number?,
        val isFiat: Number?,
        val isMarketCapIncludedInCalc: Number?,
        val lastUpdated: String?,
        val maxSupply: Number?,
        val name: String?,
        val numMarketPairs: Number?,
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

    data class Status(
        val creditCount: Number?,
        val elapsed: Number?,
        val errorCode: Number?,
        val errorMessage: Any?,
        val notice: Any?,
        val timestamp: String?
    )
}