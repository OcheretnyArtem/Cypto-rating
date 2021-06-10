package by.ocheretny.cyptorating.dataBase.entity.currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class Data(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Number?,
    @ColumnInfo(name = "circulating_supply")
    val circulatingSupply: Number?,
    @ColumnInfo(name = "cmc_rank")
    val cmcRank: Number?,
    @ColumnInfo(name = "date_added")
    val dateAdded: String?,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: String?,
    @ColumnInfo(name = "max_supply")
    val maxSupply: Number?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "num_market_pairs")
    val numMarketPairs: Number?,
    @ColumnInfo(name = "platform")
    val platform: Any?,
    @ColumnInfo(name = "slug")
    val slug: String?,
    @ColumnInfo(name = "symbol")
    val symbol: String?,
    @ColumnInfo(name = "total_supply")
    val totalSupply: Number?
)