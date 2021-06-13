package com.uogames.longProject.HW8.recycler

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import by.ocheretny.cyptorating.ui.DataFragment
import by.ocheretny.cyptorating.ui.NetworkingViewModel
import com.squareup.picasso.Picasso
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder

class CryptoRecycler(layout: Int, items: List<Data>, val viewModel: NetworkingViewModel) :
    SimpleRecyclerAdapter<Data, CryptoRecycler.CryptoViewHolder>(layout, items) {

    inner class CryptoViewHolder(view: View) : SimpleViewHolder<Data>(view) {

        override fun setData(itemView: View, any: Data) {
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

            viewModel.updateQuote(any.symbol ?: "BTC", "USD") {
                cryptoPay.text = it.price.toString()
                cryptoChangePay.text = it.percentChange1h.toString()
            }

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(DataFragment.SYMBOL, any.symbol)
                it.findNavController().navigate(R.id.show_info, bundle)
            }
        }
    }

    override fun createViewHolder(view: View): CryptoViewHolder {
        return CryptoViewHolder(view)
    }

}