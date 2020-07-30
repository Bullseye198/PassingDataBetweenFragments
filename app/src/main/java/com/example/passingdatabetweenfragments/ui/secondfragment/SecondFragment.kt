package com.example.passingdatabetweenfragments.ui.secondfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import com.example.passingdatabetweenfragments.R

class SecondFragment : Fragment() {

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_second, container, false)
        viewModel = ViewModelProviders.of(this).get(SecondViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch1 = view.findViewById<Switch>(R.id.switch1)
        val switch2 = view.findViewById<Switch>(R.id.switch2)
        val switch3 = view.findViewById<Switch>(R.id.switch3)
        val switch4 = view.findViewById<Switch>(R.id.switch4)
        val switches = listOf<Switch>(switch1, switch2, switch3, switch4)

        val switchesNum = "Number of switches is: ${switches.size.toLong()}"
        view.findViewById<TextView>(R.id.txtSwitchesNum).text = switchesNum

    }
}