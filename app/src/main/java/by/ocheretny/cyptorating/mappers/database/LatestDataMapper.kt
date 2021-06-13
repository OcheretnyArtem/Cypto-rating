package by.ocheretny.cyptorating.mappers.database

import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import by.ocheretny.cyptorating.networking.data.entities.currency.LatestData
import com.uogames.longProject.HW8.mappers.Mapper

class LatestDataMapper:Mapper<LatestData.Data, Data> {
    override fun map(from: LatestData.Data): Data {
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