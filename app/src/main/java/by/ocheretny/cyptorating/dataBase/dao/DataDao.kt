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

}