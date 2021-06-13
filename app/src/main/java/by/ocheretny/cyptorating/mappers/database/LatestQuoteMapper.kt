package by.ocheretny.cyptorating.mappers.database

import by.ocheretny.cyptorating.dataBase.entity.currency.Quote
import by.ocheretny.cyptorating.networking.data.entities.currency.LatestData
import com.uogames.longProject.HW8.mappers.Mapper

class LatestQuoteMapper {
    fun map(from: LatestData.Data.Quote, nameData: String, nameQuote: String): Quote {
        return Quote(
            lastUpdated = from.lastUpdated,
            marketCap = from.marketCap?.toDouble(),
            nameData = nameData,
            nameQuote = nameQuote,
            percentChange1h = from.percentChange1h?.toDouble(),
            percentChange7d = from.percentChange7d?.toDouble(),
            percentChange24h = from.percentChange24h?.toDouble(),
            percentChange30d = from.percentChange30d?.toDouble(),
            percentChange60d = from.percentChange60d?.toDouble(),
            percentChange90d = from.percentChange90d?.toDouble(),
            price = from.price?.toDouble(),
            volume24h = from.volume24h?.toDouble()
        )
    }
}