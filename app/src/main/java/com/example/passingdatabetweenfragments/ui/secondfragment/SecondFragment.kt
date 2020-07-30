package com.example.passingdatabetweenfragments.ui.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.databinding.FragmentSecondBinding
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SecondFragment : DaggerFragment() {

    private lateinit var viewModel: SecondViewModel
    private lateinit var mBinding: FragmentSecondBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch1 = view.findViewById<Switch>(R.id.switch1)
        val switch2 = view.findViewById<Switch>(R.id.switch2)
        val switch3 = view.findViewById<Switch>(R.id.switch3)
        val switch4 = view.findViewById<Switch>(R.id.switch4)
        val switches = listOf<Switch>(switch1, switch2, switch3, switch4).size.toLong()

        val switchesNum = "Number of switches is: $switches"
        view.findViewById<TextView>(R.id.txtSwitchesNum).text = switchesNum

        viewModel.setNumberOfSwitches(switches)
    }
}