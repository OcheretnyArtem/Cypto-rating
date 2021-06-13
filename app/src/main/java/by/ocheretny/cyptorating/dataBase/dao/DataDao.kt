package by.ocheretny.cyptorating.dataBase.dao

import androidx.room.*
import by.ocheretny.cyptorating.dataBase.entity.currency.Data


@Dao
interface DataDao {

    @Insert
    suspend fun insertData(Data: Data)

    @Update
    suspend fun updateData(Data: Data)

    @Query("SELECT * FROM crypto_table")
    suspend fun getAllData(): List<Data>


    @Query("SELECT * FROM crypto_table WHERE symbol = :symbol")
    fun getDataBySymbol(symbol: String): List<Data>

    @Query("SELECT * FROM crypto_table WHERE category = :category")
    fun getDataByCategory(category: Long): List<Data>
}