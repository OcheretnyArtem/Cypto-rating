package by.ocheretny.cyptorating.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.ocheretny.cyptorating.R
import com.uogames.longProject.HW8.recycler.CryptoRecycler

class ShowTopFragment : Fragment() {

    private val networkingViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(NetworkingViewModel::class.java)
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

        val recycler = view.findViewById<RecyclerView>(R.id.crypto_recycler)

        networkingViewModel.updateTopCrypto {
            val adapter = CryptoRecycler(R.layout.item_crypto, it, networkingViewModel)
            recycler.adapter = adapter
            recycler.refreshDrawableState()
        }
    }

}