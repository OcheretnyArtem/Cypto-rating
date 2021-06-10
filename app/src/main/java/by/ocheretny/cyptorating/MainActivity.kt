package by.ocheretny.cyptorating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.uogames.longProject.HW8.NetworkingViewModel
import com.uogames.longProject.HW8.recycler.CryptoRecycler

class MainActivity : AppCompatActivity() {
    private val networkingViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(application)
            .create(NetworkingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw8)

        val recycler = findViewById<RecyclerView>(R.id.hw8_crypto_recycler)

        networkingViewModel.listingData.observe(this) {
            val adapter =
                it.data?.let { it1 ->
                    CryptoRecycler(
                        R.layout.fragment_item_crypto_hw8,
                        it1,
                        application
                    )
                }
            recycler.adapter = adapter
        }

        networkingViewModel.updateListingData()

    }
}