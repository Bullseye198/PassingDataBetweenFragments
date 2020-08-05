package com.example.passingdatabetweenfragments.ui.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.passingdatabetweenfragments.R
import com.example.passingdatabetweenfragments.databinding.FragmentSecondBinding
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SecondFragment : DaggerFragment() {

    private lateinit var viewModel: SecondViewModel
    private lateinit var mBinding: FragmentSecondBinding
    private var isChecked: Boolean = false
    private var switchId: Int = 0

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

        viewModel.getNumberOfSelectedSwitchesFromRepo()
        showCheckedSwitches()

        val switches = listOf(
            mBinding.switch1,
            mBinding.switch2,
            mBinding.switch3,
            mBinding.switch4
        ).size.toLong()

        val switchesNum = "Number of switches is: $switches"
        view.findViewById<TextView>(R.id.txtSwitchesNum).text = switchesNum

        viewModel.setNumberOfSwitches(switches)

        mBinding.switch1.setOnClickListener {
            if (mBinding.switch1.isChecked) {
                switchId = mBinding.switch1.id
                isChecked = true
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            } else {
                switchId = mBinding.switch1.id
                isChecked = false
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            }
        }

        mBinding.switch2.setOnClickListener {
            if (mBinding.switch2.isChecked) {
                switchId = mBinding.switch2.id
                isChecked = true
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            } else {
                switchId = mBinding.switch2.id
                isChecked = false
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            }
        }

        mBinding.switch3.setOnClickListener {
            if (mBinding.switch3.isChecked) {
                switchId = mBinding.switch3.id
                isChecked = true
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            } else {
                switchId = mBinding.switch3.id
                isChecked = false
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            }
        }

        mBinding.switch4.setOnClickListener {
            if (mBinding.switch4.isChecked) {
                switchId = mBinding.switch4.id
                isChecked = true
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            } else {
                switchId = mBinding.switch4.id
                isChecked = false
                viewModel.setNumberOfSelectedSwitches(isChecked, switchId)
            }
        }
    }

    private fun showCheckedSwitches() {
        val switchesIds = listOf(
            mBinding.switch1.id,
            mBinding.switch2.id,
            mBinding.switch3.id,
            mBinding.switch4.id
        )
        viewModel.getSelectedNumberOfSwitches().observe(viewLifecycleOwner, Observer { t ->

            println("IDs from All switches: $switchesIds")
            println("IDs from selected switches: $t")
            mBinding.switch1.isChecked = t.contains(mBinding.switch1.id)
            mBinding.switch2.isChecked = t.contains(mBinding.switch2.id)
            mBinding.switch3.isChecked = t.contains(mBinding.switch3.id)
            mBinding.switch4.isChecked = t.contains(mBinding.switch4.id)
        })
    }
}