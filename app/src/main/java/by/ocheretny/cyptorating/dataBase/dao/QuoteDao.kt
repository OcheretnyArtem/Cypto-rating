package by.ocheretny.cyptorating.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("SELECT * FROM quote_table WHERE nameData = :nameData AND nameQuote=:nameQuote")
    suspend fun getQuote(nameData: String?, nameQuote: String) : List<Quote>
}