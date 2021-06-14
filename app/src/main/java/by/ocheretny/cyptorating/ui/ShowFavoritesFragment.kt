package by.ocheretny.cyptorating.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.cyptorating.R
import by.ocheretny.cyptorating.recycler.CryptoRecycler

class ShowFavoritesFragment : Fragment() {

    private val networkingViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(NetworkingViewModel::class.java)
    }

    private lateinit var eSearch: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.fav_crypto_recycler)
        val toolbar = view.findViewById<Toolbar>(R.id.tool_bar)
        eSearch = view.findViewById(R.id.search_input_text)

        networkingViewModel.loadSelectedCrypto{
                val adapter = CryptoRecycler(R.layout.item_crypto, it, networkingViewModel)
                Log.e("TAG" , recycler.toString())
                recycler.adapter = adapter
        }

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.top_100 -> {
                    view.findNavController().navigate(R.id.action_show_selected_to_showFragment)
                    true
                }
                R.id.search -> {
                    if (eSearch.visibility == View.GONE) {
                        it.setIcon(R.drawable.ic_baseline_done_24)
                        eSearch.visibility = View.VISIBLE
                        eSearch.doAfterTextChanged {

                        }
                    } else if (eSearch.visibility == View.VISIBLE) {
                        it.setIcon(R.drawable.ic_baseline_search_24)
                        eSearch.visibility = View.GONE
                        eSearch.text.clear()
                    }
                    true
                }
                else -> false
            }
        }
    }
}