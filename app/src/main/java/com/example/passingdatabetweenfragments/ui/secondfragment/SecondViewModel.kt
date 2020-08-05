package com.example.passingdatabetweenfragments.ui.secondfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.DecreaseNumberOfSelectedSwitchesUseCase
import com.example.domain.usecases.IncreaseNumberOfSelectedSwitchesUseCase
import com.example.domain.usecases.SetNumberOfSelectedSwitchesUseCase
import com.example.domain.usecases.SetNumberOfSwitchesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private var setNumberOfSwitchesUseCase: SetNumberOfSwitchesUseCase,
    private var setNumberOfSelectedSwitchesUseCase: SetNumberOfSelectedSwitchesUseCase,
    private var increaseNumberOfSelectedSwitchesUseCase: IncreaseNumberOfSelectedSwitchesUseCase,
    private var decreaseNumberOfSelectedSwitchesUseCase: DecreaseNumberOfSelectedSwitchesUseCase
) : ViewModel() {

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

    fun increaseNumberOfSwitches() {
        viewModelScope.launch {
            increaseNumberOfSelectedSwitchesUseCase.increaseNumbers()
        }
    }

    fun decreaseNumberOfSwitches() {
        viewModelScope.launch {
            decreaseNumberOfSelectedSwitchesUseCase.decreaseNumbers()
        }
    }
}