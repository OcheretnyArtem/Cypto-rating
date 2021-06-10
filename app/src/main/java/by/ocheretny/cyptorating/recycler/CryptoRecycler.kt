package com.uogames.longProject.HW8.recycler

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import by.ocheretny.cyptorating.R
import com.squareup.picasso.Picasso
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder
import com.uogames.longProject.HW8.NetworkingViewModel
import com.uogames.longProject.HW8.data.entities.currency.ListingData

class CryptoRecycler(layout: Int, items: List<ListingData.Data>, application: Application) :
    SimpleRecyclerAdapter<ListingData.Data, CryptoRecycler.CryptoViewHolder>(layout, items) {

    private val networkingViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(application)
            .create(NetworkingViewModel::class.java)
    }

    inner class CryptoViewHolder(view: View) : SimpleViewHolder<ListingData.Data>(view) {

        override fun setData(itemView: View, any: ListingData.Data) {
            val logo = itemView.findViewById<ImageView>(R.id.hw8_crypto_logo)
            val trend = itemView.findViewById<ImageView>(R.id.hw8_crypto_trend)
            val cryptoName = itemView.findViewById<TextView>(R.id.hw8_crypto_name)
            val cryptoPay = itemView.findViewById<TextView>(R.id.hw8_pay_usd)
            val cryptoChangePay = itemView.findViewById<TextView>(R.id.hw8_change_pay)

            Picasso.get().load(
                itemView.context.getString(R.string.link_get_logo_crypto) + any.id + itemView.context.getString(
                    R.string.png_format
                )
            ).into(logo)
            Picasso.get().load(
                itemView.context.getString(R.string.link_crypto_trend) + any.id + itemView.context.getString(
                    R.string.png_format
                )
            ).into(trend)
            cryptoName.text = any.name

            any.quote?.forEach { k, v ->
                cryptoPay.text = "$ " + v.price.toString()
                cryptoChangePay.text = "24 hour: " + v.percentChange24h.toString() + "%"
            }

            networkingViewModel.loadLatestFromName(any.id.toString(),"BYN"){

            }


        }
    }

    override fun createViewHolder(view: View): CryptoViewHolder {
        return CryptoViewHolder(view)
    }

}