package com.uogames.longProject.HW8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.cyptorating.R
import com.uogames.longProject.HW8.recycler.CryptoRecycler

class MainActivityHW8 : AppCompatActivity() {
    private val networkingViewModel by lazy { ViewModelProvider(this).get(NetworkingViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw8)

        val recycler = findViewById<RecyclerView>(R.id.hw8_crypto_recycler)





        networkingViewModel.listingData.observe(this){
            val adapter =
                it.data?.let { it1 -> CryptoRecycler(R.layout.fragment_item_crypto_hw8, it1) }
            recycler.adapter = adapter
        }

        networkingViewModel.updateListingData()

    }
}