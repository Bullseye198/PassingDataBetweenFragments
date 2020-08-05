package com.example.passingdatabetweenfragments.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.passingdatabetweenfragments.Money
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelFactory
import dagger.android.support.DaggerFragment
import java.lang.Exception
import javax.inject.Inject

class SlideshowFragment : DaggerFragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    private var recipient: String? = null
    private var money: Money? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            recipient = requireArguments().getString("recipient")!!
            money = requireArguments().getParcelable("amount")!!
        } catch (e: Exception) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = money?.amount
        val confirmationMessage = "You have sent $amount Euro to $recipient."
        view.findViewById<TextView>(R.id.txtResult).text = confirmationMessage
    }
}