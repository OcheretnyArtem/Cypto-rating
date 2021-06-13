package by.ocheretny.cyptorating.mappers.database

import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.mappers.Mapper

class ListingDataMapper : Mapper<ListingData.Data, Data> {
    override fun map(from: ListingData.Data): Data {
        return Data(
            id = from.id?.toInt(),
            name = from.name,
            totalSupply = from.totalSupply?.toLong(),
            numMarketPairs = from.numMarketPairs?.toLong(),
            maxSupply = from.maxSupply?.toLong(),
            cmcRank = from.cmcRank?.toLong(),
            circulatingSupply = from.circulatingSupply?.toLong(),
            lastUpdated = from.lastUpdated,
            slug = from.slug,
            symbol = from.symbol
        )
    }
}