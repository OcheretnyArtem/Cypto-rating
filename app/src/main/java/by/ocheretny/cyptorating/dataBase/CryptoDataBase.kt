package by.ocheretny.cyptorating.dataBase

import android.content.Context
import androidx.room.*
import by.ocheretny.cyptorating.dataBase.dao.DataDao
import by.ocheretny.cyptorating.dataBase.dao.QuoteDao
import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote

@Database(entities = [Data::class, Quote::class], version = 1)
abstract class CryptoDataBase : RoomDatabase() {

    abstract fun DataDao(): DataDao
    abstract fun QuoteDao(): QuoteDao

    companion object {
        var INSTANCE: CryptoDataBase? = null

        fun getCoffeeDataBase(context: Context): CryptoDataBase {
            return if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, CryptoDataBase::class.java, "database").build()
                INSTANCE as CryptoDataBase
            } else INSTANCE as CryptoDataBase
        }
    }

}