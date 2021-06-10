package by.ocheretny.cyptorating.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.cyptorating.R
import com.uogames.longProject.HW8.recycler.CryptoRecycler

class ShowFragment : Fragment() {

    private val networkingViewModel by lazy {
        ViewModelProvider(requireActivity()).get(
            NetworkingViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("rrr","sfs")

        val recycler = view.findViewById<RecyclerView>(R.id.crypto_recycler)

        networkingViewModel.listingData.observe(requireActivity()) {
            val adapter =
                it.data?.let { it1 -> CryptoRecycler(R.layout.item_crypto, it1,networkingViewModel) }
            recycler.adapter = adapter
        }

        networkingViewModel.updateListingData()
    }

}