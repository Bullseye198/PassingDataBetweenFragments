package com.example.passingdatabetweenfragments.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetNumberOfSelectedSwitchesUseCase
import com.example.domain.usecases.GetNumberOfSwitchesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private var getNumberOfSwitchesUseCase: GetNumberOfSwitchesUseCase,
    private var getNumberOfSelectedSwitchesUseCase: GetNumberOfSelectedSwitchesUseCase
) : ViewModel() {

    private val getNumberOfSwitchesLiveData: MutableLiveData<Long> = MutableLiveData()
    fun getNumberOfSwitches(): MutableLiveData<Long> = getNumberOfSwitchesLiveData

    private val getNumberOfSelectedSwitchesLiveData: MutableLiveData<Int> = MutableLiveData()
    fun getSelectedNumberOfSwitches(): MutableLiveData<Int> = getNumberOfSelectedSwitchesLiveData

    private val _text = MutableLiveData<String>().apply {
        value = "Enter a name"
    }
    val text: LiveData<String> = _text

    fun getNumberOfSwitchesFromRepo() {
        viewModelScope.launch {
            val numberOfSwitches = withContext(Dispatchers.IO) {
                getNumberOfSwitchesUseCase.getNumber()
            }
            getNumberOfSwitchesLiveData.value = numberOfSwitches
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