package by.ocheretny.cyptorating.dataBase.entity.currency

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "quote_table"
)
data class Quote(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "nameQuote")
    val nameQuote: String?,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: String?,
    @ColumnInfo(name = "market_cap")
    val marketCap: Double?,
    @ColumnInfo(name = "percent_change_1h")
    val percentChange1h: Double?,
    @ColumnInfo(name = "percent_change_24h")
    val percentChange24h: Double?,
    @ColumnInfo(name = "percent_change_30d")
    val percentChange30d: Double?,
    @ColumnInfo(name = "percent_change_60d")
    val percentChange60d: Double?,
    @ColumnInfo(name = "percent_change_7d")
    val percentChange7d: Double?,
    @ColumnInfo(name = "percent_change_90d")
    val percentChange90d: Double?,
    @ColumnInfo(name = "price")
    val price: Double?,
    @ColumnInfo(name = "volume_24h")
    val volume24h: Double?
)
