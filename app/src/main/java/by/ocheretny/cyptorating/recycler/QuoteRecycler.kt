package by.ocheretny.cyptorating.recycler

import android.view.View
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote
import by.ocheretny.cyptorating.ui.NetworkingViewModel
import com.uogames.lesson23.recycler.SimpleRecyclerAdapter
import com.uogames.lesson23.recycler.SimpleViewHolder

class QuoteRecycler(layout: Int, items:List<Quote>, networkingViewModel: NetworkingViewModel) : SimpleRecyclerAdapter<Quote, QuoteRecycler.QuoteHolder> (layout, items){

    inner class QuoteHolder(view: View) : SimpleViewHolder<Quote>(view) {
        override fun setData(itemView: View, any: Quote) {

        }
    }

    override fun createViewHolder(view: View): QuoteHolder {
        return QuoteHolder(view)
    }
}