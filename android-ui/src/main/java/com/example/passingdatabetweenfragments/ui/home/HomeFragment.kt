package com.example.passingdatabetweenfragments.ui.home

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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.passingdatabetweenfragments.Money
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.databinding.FragmentHomeBinding
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mBinding: FragmentHomeBinding

    private var recipient: String? = null
    private var money: Money? = null

    private var navController: NavController? = null

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnFragment2).setOnClickListener {
            val direction = HomeFragmentDirections.actionNavHomeToSecondFragment()
            findNavController().navigate(direction)
        }

        val amount = money?.amount
        val confirmationMessage = "You have sent $amount Euro to $recipient."
        view.findViewById<TextView>(R.id.txtHomeResult).text = confirmationMessage

        homeViewModel.getNumberOfSwitchesFromRepo()
        observeViewModel()
        homeViewModel.getNumberOfSelectedSwitchesFromRepo()
        homeViewModel.getSelectedNumberOfSwitches()
            .observe(viewLifecycleOwner, Observer { selectedSwitches ->
                val text = "Number of selected switches from fragment two: ${selectedSwitches.size}"
                mBinding.txtNumberOfSelectedSwitches.text = text
            })
    }

    private fun observeViewModel() {
        homeViewModel.getNumberOfSwitches().observe(viewLifecycleOwner, Observer { switches ->
            if (switches != null) {
                val text = "Number of total switches from fragment two: $switches"
                mBinding.txtNumberOfSwitches.text = text
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            mBinding.textHome.text = it
        })
        return mBinding.root
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
