package by.ocheretny.cyptorating.dataBase.entity.currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class Data(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "circulating_supply")
    val circulatingSupply: Long?,
    @ColumnInfo(name = "cmc_rank")
    val cmcRank: Long?,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: String?,
    @ColumnInfo(name = "max_supply")
    val maxSupply: Long?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "num_market_pairs")
    val numMarketPairs: Long?,
    @ColumnInfo(name = "slug")
    val slug: String?,
    @ColumnInfo(name = "symbol")
    val symbol: String?,
    @ColumnInfo(name = "total_supply")
    val totalSupply: Long?,
    @ColumnInfo(name = "category")
    var category: Long? = 0
)
