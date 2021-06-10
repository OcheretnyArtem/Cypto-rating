package com.uogames.longProject.HW8.mappers.currency

import by.ocheretny.cyptorating.data.dto.currency.LatestDataResponse
import com.uogames.longProject.HW8.data.dto.currency.ListingDataResponse
import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.mappers.Mapper

class ListingDataMapper : Mapper<ListingDataResponse, ListingData> {


    override fun map(from: ListingDataResponse): ListingData {
        val data: ArrayList<ListingData.Data> = ArrayList()
        from.data?.forEach {
            it?.let { ld ->
                data.add(
                    ListingData.Data(
                        circulatingSupply = ld.circulatingSupply ?: 0.0,
                        cmcRank = ld.cmcRank ?: -1,
                        dateAdded = ld.dateAdded.orEmpty(),
                        id = ld.id ?: -1,
                        lastUpdated = ld.lastUpdated.orEmpty(),
                        maxSupply = ld.maxSupply ?: -1,
                        name = ld.name.orEmpty(),
                        numMarketPairs = ld.numMarketPairs ?: -1,
                        platform = ld.platform ?: "null",
                        quote = HashMap<String, ListingData.Data.Quote>().apply {
                            ld.quote?.forEach { k, v ->
                                put(
                                    k, ListingData.Data.Quote(
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
                        }                        ,
                        slug = ld.slug.orEmpty(),
                        symbol = ld.symbol.orEmpty(),
                        tags = ld.tags ?: ArrayList<String>(),
                        totalSupply = ld.totalSupply ?: 0.0
                    )
                )
            }
        }

        return ListingData(data)
    }


}