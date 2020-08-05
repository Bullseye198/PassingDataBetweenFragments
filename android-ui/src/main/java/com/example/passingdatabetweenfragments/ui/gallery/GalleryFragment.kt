package com.example.passingdatabetweenfragments.ui.gallery

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.passingdatabetweenfragments.Money
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.lang.Exception
import java.math.BigDecimal
import javax.inject.Inject

class GalleryFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var galleryViewModel: GalleryViewModel
    var navController: NavController? = null

    private var recipient: String? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            recipient = requireArguments().getString("recipient")!!
        } catch (e: Exception) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button2).setOnClickListener(this)
        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.recipientnametext).text = message
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button2 -> {
                if (!TextUtils.isEmpty(txtAmount.text.toString())) {
                    val amount = Money(BigDecimal(txtAmount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    val navOptions = NavOptions.Builder().setPopUpTo(R.id.nav_home, true).build()
                    navController!!.previousBackStackEntry?.savedStateHandle?.set("bundle",bundle)
                    navController!!.navigate(R.id.nav_home, bundle, navOptions)
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
