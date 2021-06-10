package by.ocheretny.cyptorating.dataBase.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote

interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("SELECT * FROM quote_table WHERE id = :id")
    suspend fun getQuote(id: Number) : Quote
}