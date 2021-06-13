package by.ocheretny.cyptorating.mappers.network

import by.ocheretny.cyptorating.networking.data.dto.currency.LatestDataResponse
import by.ocheretny.cyptorating.networking.data.entities.currency.LatestData
import com.uogames.longProject.HW8.mappers.Mapper

class LatestDataMapper : Mapper<LatestDataResponse, LatestData> {

    override fun map(from: LatestDataResponse): LatestData {
        val data: HashMap<String, LatestData.Data> = HashMap()
        from.data?.forEach {
            data.put(
                it.key, LatestData.Data(
                    circulatingSupply = it.value.circulatingSupply ?: 0.0,
                    cmcRank = it.value.cmcRank ?: -1,
                    dateAdded = it.value.dateAdded.orEmpty(),
                    id = it.value.id ?: -1,
                    lastUpdated = it.value.lastUpdated.orEmpty(),
                    maxSupply = it.value.maxSupply ?: -1,
                    name = it.value.name.orEmpty(),
                    numMarketPairs = it.value.numMarketPairs ?: -1,
                    quote = HashMap<String, LatestData.Data.Quote>().apply {
                        it.value.quote?.forEach { k, v ->
                            put(
                                k, LatestData.Data.Quote(
                                    lastUpdated = v.lastUpdated.orEmpty(),
                                    marketCap = v.marketCap ?: 0.0,
                                    percentChange1h = v.percentChange1h ?: 0.0,
                                    percentChange24h = v.percentChange24h ?: 0.0,
                                    percentChange30d = v.percentChange30d ?: 0.0,
                                    percentChange60d = v.percentChange60d ?: 0.0,
                                    percentChange7d = v.percentChange7d ?: 0.0,
                                    percentChange90d = v.percentChange90d ?: 0.0,
                                    price = v.price ?: 0.0,
                                    volume24h = v.volume24h ?: 0.0
                                )
                            )
                        }
                    },
                    slug = it.value.slug.orEmpty(),
                    symbol = it.value.symbol.orEmpty(),
                    tags = it.value.tags ?: ArrayList<String>(),
                    totalSupply = it.value.totalSupply ?: 0.0,
                    isFiat = it.value.isFiat,
                    isMarketCapIncludedInCalc = it.value.isMarketCapIncludedInCalc
                )
            )
        }
        val status = LatestData.Status(
            creditCount = from.status?.creditCount,
            elapsed = from.status?.elapsed,
            errorCode = from.status?.errorCode,
            errorMessage = from.status?.errorMessage,
            notice = from.status?.notice,
            timestamp = from.status?.timestamp,
        )
        return LatestData(data, status)
    }

}