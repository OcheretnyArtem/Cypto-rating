package by.ocheretny.cyptorating.recycler

import android.view.View
import android.widget.TextView
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote
import by.ocheretny.cyptorating.ui.NetworkingViewModel
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder

class QuoteRecycler(layout: Int, items:List<Quote>, val networkingViewModel: NetworkingViewModel) : SimpleRecyclerAdapter<Quote, QuoteRecycler.QuoteHolder> (layout, items){

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
            price.text = any.price.toString()
            volume24h.text = any.volume24h.toString()
            percentChange1h.text = any.percentChange1h.toString()
            percentChange24h.text = any.percentChange24h.toString()
            percentChange7d.text = any.percentChange7d.toString()
            percentChange30d.text = any.percentChange30d.toString()
            percentChange60d.text = any.percentChange60d.toString()
            percentChange90d.text = any.percentChange90d.toString()
            marketCap.text = any.marketCap.toString()
            lastUpdated.text = any.lastUpdated.toString()

            any.nameData?.let {
                any.nameQuote?.let { it1 ->
                    networkingViewModel.updateQuote(it, it1){
                        quoteName.text = it.nameQuote
                        price.text = it.price.toString()
                        volume24h.text = it.volume24h.toString()
                        percentChange1h.text = it.percentChange1h.toString()
                        percentChange24h.text = it.percentChange24h.toString()
                        percentChange7d.text = it.percentChange7d.toString()
                        percentChange30d.text = it.percentChange30d.toString()
                        percentChange60d.text = it.percentChange60d.toString()
                        percentChange90d.text = it.percentChange90d.toString()
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