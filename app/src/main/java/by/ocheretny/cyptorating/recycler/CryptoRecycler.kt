package by.ocheretny.cyptorating.recycler

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import by.ocheretny.cyptorating.ui.NetworkingViewModel
import by.ocheretny.cyptorating.ui.ShowItemFragment
import com.squareup.picasso.Picasso
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder

class CryptoRecycler(layout: Int, items: List<Data>, val viewModel: NetworkingViewModel) :
    SimpleRecyclerAdapter<Data, CryptoRecycler.CryptoViewHolder>(layout, items) {

    inner class CryptoViewHolder(view: View) : SimpleViewHolder<Data>(view) {

        override fun setData(itemView: View, any: Data) {
            val logo = itemView.findViewById<ImageView>(R.id.hw8_crypto_logo)
            val cryptoName = itemView.findViewById<TextView>(R.id.hw8_crypto_name)
            val cryptoPay = itemView.findViewById<TextView>(R.id.hw8_pay_usd)
            val cryptoChangePay = itemView.findViewById<TextView>(R.id.hw8_change_pay)

            Picasso.get().load(
                itemView.context.getString(R.string.link_get_logo_crypto) + any.id + itemView.context.getString(
                    R.string.png_format
                )
            ).into(logo)
            cryptoName.text = any.name

            viewModel.updateQuote(any.symbol ?: "BTC", "USD") {
                cryptoPay.text = String.format("%.3f ${it.nameQuote}", it.price)
                cryptoChangePay.text = String.format("%.3f", it.percentChange1h) + " %"
            }

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(ShowItemFragment.SYMBOL, any.symbol)
                it.findNavController().navigate(R.id.showItemFragment, bundle)
            }
        }
    }

    override fun createViewHolder(view: View): CryptoViewHolder {
        return CryptoViewHolder(view)
    }

}