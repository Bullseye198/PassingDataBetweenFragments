package com.example.passingdatabetweenfragments.ui.home

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.passingdatabetweenfragments.Money
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Exception
import java.lang.reflect.Type

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel

    var recipient: String? = null
    var money: Money? = null

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            recipient = requireArguments().getString("recipient")!!
            money = requireArguments().getParcelable("amount")!!
        } catch (e:Exception) {
            val x = e
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)

        val amount = money?.amount
        val confirmationMessage = "You have sent $amount Euro to $recipient."
        view.findViewById<TextView>(R.id.txtHomeResult).text = confirmationMessage
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button -> {
                if (!TextUtils.isEmpty(txtName.text.toString())) {
                    val bundle = bundleOf("recipient" to txtName.text.toString())
                    navController!!.navigate(
                        R.id.action_nav_home_to_nav_gallery,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an recipient", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
