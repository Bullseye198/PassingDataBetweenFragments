package com.example.passingdatabetweenfragments.ui.secondfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.SetNumberOfSwitchesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private var setNumberOfSwitchesUseCase: SetNumberOfSwitchesUseCase

) : ViewModel() {

    fun setNumberOfSwitches(number: Long) {
        viewModelScope.launch {
            setNumberOfSwitchesUseCase.setNumber(number)
        }
    }
}