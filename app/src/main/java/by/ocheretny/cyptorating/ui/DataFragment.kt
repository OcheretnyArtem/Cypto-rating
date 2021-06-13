package by.ocheretny.cyptorating.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.recycler.QuoteRecycler
import com.squareup.picasso.Picasso

class DataFragment:Fragment() {
    companion object {
        const val SYMBOL = "SYMBOL"
    }
    private val networkingViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(NetworkingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageCrypto = view.findViewById<ImageView>(R.id.image_crypto)
        val cryptoSymbol = view.findViewById<TextView>(R.id.crypto_symbol)
        val cryptoName = view.findViewById<TextView>(R.id.crypto_name)
        val cryptoRank = view.findViewById<TextView>(R.id.crypto_rank)
        val maxSupply = view.findViewById<TextView>(R.id.max_supply)
        val circulatingSupply = view.findViewById<TextView>(R.id.circulating_supply)
        val totalSupply = view.findViewById<TextView>(R.id.total_supply)
        val lastUpdated = view.findViewById<TextView>(R.id.last_updated)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_quotes)


        val string = arguments?.getString(SYMBOL)
        if (string != null) {
            networkingViewModel.loadSelectedCrypto (string){
                if (it.isNotEmpty()){
                    val data = it[0]
                    Picasso.get().load(
                        view.context.getString(R.string.link_get_logo_crypto) + data.id + view.context.getString(
                            R.string.png_format
                        )
                    ).into(imageCrypto)
                    cryptoSymbol.text = data.symbol
                    cryptoName.text = data.name
                    cryptoRank.text = data.cmcRank.toString()
                    maxSupply.text = data.maxSupply.toString()
                    circulatingSupply.text = data.circulatingSupply.toString()
                    totalSupply.text = data.totalSupply.toString()
                    lastUpdated.text = data.lastUpdated
                    data.symbol?.let { it1 ->
                        networkingViewModel.loadQuotes(it1){ list ->
                            recycler.adapter = QuoteRecycler(R.layout.item_quotes, list, networkingViewModel)
                        }
                    }
                }
            }
        }
    }

}