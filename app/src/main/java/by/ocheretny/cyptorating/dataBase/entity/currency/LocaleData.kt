//package by.ocheretny.cyptorating.dataBase.entity.currency
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//
//@Entity(tableName = "crypto_table")
//data class LocaleData(val `data`: List<Data>?) {
//    data class Data(
//        @ColumnInfo(name = "circulating_supply")
//        val circulatingSupply: Number?,
//        @ColumnInfo(name = "cmc_rank")
//        val cmcRank: Number?,
//        @ColumnInfo(name = "date_added")
//        val dateAdded: String?,
//        @ColumnInfo(name = "id")
//        val id: Number?,
//        @ColumnInfo(name = "last_updated")
//        val lastUpdated: String?,
//        @ColumnInfo(name = "max_supply")
//        val maxSupply: Number?,
//        @ColumnInfo(name = "name")
//        val name: String?,
//        @ColumnInfo(name = "num_market_pairs")
//        val numMarketPairs: Number?,
//        @ColumnInfo(name = "platform")
//        val platform: Any?,
//        @ColumnInfo(name = "quote")
//        val quote: Quote?,
//        @ColumnInfo(name = "slug")
//        val slug: String?,
//        @ColumnInfo(name = "symbol")
//        val symbol: String?,
//        @ColumnInfo(name = "tags")
//        val tags: List<String?>?,
//        @ColumnInfo(name = "total_supply")
//        val totalSupply: Number?
//    ) {
//        data class Quote(
//            val uSD: USD?
//        ) {
//            data class USD(
//                val lastUpdated: String?,
//                val marketCap: Number?,
//                val percentChange1h: Number?,
//                val percentChange24h: Number?,
//                val percentChange30d: Number?,
//                val percentChange60d: Number?,
//                val percentChange7d: Number?,
//                val percentChange90d: Number?,
//                val price: Number?,
//                val volume24h: Number?
//            )
//        }
//    }
//}
