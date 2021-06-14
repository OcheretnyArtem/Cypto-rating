package by.ocheretny.cyptorating.recycler

import android.view.View
import android.widget.TextView
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote
import by.ocheretny.cyptorating.ui.NetworkingViewModel
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder

class QuoteRecycler(layout: Int, items: List<Quote>, val networkingViewModel: NetworkingViewModel) :
    SimpleRecyclerAdapter<Quote, QuoteRecycler.QuoteHolder>(layout, items) {

    inner class QuoteHolder(view: View) : SimpleViewHolder<Quote>(view) {
        override fun setData(itemView: View, any: Quote) {
            val quoteName = itemView.findViewById<TextView>(R.id.quote_name)
            val price = itemView.findViewById<TextView>(R.id.price)
            val volume24h = itemView.findViewById<TextView>(R.id.volume_24h)
            val percentChange1h = itemView.findViewById<TextView>(R.id.percent_change_1h)
            val percentChange24h = itemView.findViewById<TextView>(R.id.percent_change_24h)
            val percentChange7d = itemView.findViewById<TextView>(R.id.percent_change_7d)
            val percentChange30d = itemView.findViewById<TextView>(R.id.percent_change_30d)
            val percentChange60d = itemView.findViewById<TextView>(R.id.percent_change_60d)
            val percentChange90d = itemView.findViewById<TextView>(R.id.percent_change_90d)
            val marketCap = itemView.findViewById<TextView>(R.id.market_cap)
            val lastUpdated = itemView.findViewById<TextView>(R.id.last_updated)

            quoteName.text = any.nameQuote
            price.text = String.format("%.4f",any.price)
            volume24h.text = String.format("%.6f",any.volume24h)
            percentChange1h.text =  String.format("%.3f",any.percentChange1h)
            percentChange24h.text = String.format("%.3f",any.percentChange24h)
            percentChange7d.text = String.format("%.3f",any.percentChange7d)
            percentChange30d.text = String.format("%.3f",any.percentChange30d)
            percentChange60d.text = String.format("%.3f",any.percentChange60d)
            percentChange90d.text = String.format("%.3f",any.percentChange90d)
            marketCap.text = any.marketCap.toString()
            lastUpdated.text = any.lastUpdated.toString()

            any.nameData?.let {
                any.nameQuote?.let { it1 ->
                    networkingViewModel.updateQuote(it, it1) {
                        quoteName.text = it.nameQuote
                        price.text = String.format("%.3f", it.price)
                        volume24h.text = String.format("%.3f", it.volume24h)
                        percentChange1h.text = String.format("%.3f", it.percentChange1h)
                        percentChange24h.text = String.format("%.3f",it.percentChange24h)
                        percentChange7d.text = String.format("%.3f",it.percentChange7d)
                        percentChange30d.text = String.format("%.3f",it.percentChange30d)
                        percentChange60d.text = String.format("%.3f",it.percentChange60d)
                        percentChange90d.text = String.format("%.3f",it.percentChange90d)
                        marketCap.text = it.marketCap.toString()
                        lastUpdated.text = it.lastUpdated.toString()
                    }
                }
            }

        }
    }

    override fun createViewHolder(view: View): QuoteHolder {
        return QuoteHolder(view)
    }
}