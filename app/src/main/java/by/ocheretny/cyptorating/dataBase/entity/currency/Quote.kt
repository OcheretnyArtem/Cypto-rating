package by.ocheretny.cyptorating.dataBase.entity.currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote_table")
data class Quote(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Number?,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: String?,
    @ColumnInfo(name = "market_cap")
    val marketCap: Number?,
    @ColumnInfo(name = "percent_change_1h")
    val percentChange1h: Number?,
    @ColumnInfo(name = "percent_change_24h")
    val percentChange24h: Number?,
    @ColumnInfo(name = "percent_change_30d")
    val percentChange30d: Number?,
    @ColumnInfo(name = "percent_change_60d")
    val percentChange60d: Number?,
    @ColumnInfo(name = "percent_change_7d")
    val percentChange7d: Number?,
    @ColumnInfo(name = "percent_change_90d")
    val percentChange90d: Number?,
    @ColumnInfo(name = "price")
    val price: Number?,
    @ColumnInfo(name = "volume_24h")
    val volume24h: Number?
)
