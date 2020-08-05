package com.example.passingdatabetweenfragments.ui.secondfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private var setNumberOfSwitchesUseCase: SetNumberOfSwitchesUseCase,
    private var setNumberOfSelectedSwitchesUseCase: SetNumberOfSelectedSwitchesUseCase,
    private var getNumberOfSelectedSwitchesUseCase: GetNumberOfSelectedSwitchesUseCase
) : ViewModel() {

    private val getNumberOfSelectedSwitchesLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
    fun getSelectedNumberOfSwitches(): MutableLiveData<MutableList<Int>> = getNumberOfSelectedSwitchesLiveData

    fun setNumberOfSwitches(number: Long) {
        viewModelScope.launch {
            setNumberOfSwitchesUseCase.setNumber(number)
        }
    }

    fun setNumberOfSelectedSwitches(isEnabled: Boolean, id: Int) {
        viewModelScope.launch {
            setNumberOfSelectedSwitchesUseCase.setNumberOfSelectedSwitches(isEnabled, id)
        }
    }

    fun getNumberOfSelectedSwitchesFromRepo() {
        viewModelScope.launch {
            val numberOfSelectedSwitches = withContext(Dispatchers.IO) {
                getNumberOfSelectedSwitchesUseCase.getNumberOfSelectedSwitches()
            }
            getNumberOfSelectedSwitchesLiveData.value = numberOfSelectedSwitches
        }
    }
}