package com.example.passingdatabetweenfragments.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetNumberOfSwitchesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private var getNumberOfSwitchesUseCase: GetNumberOfSwitchesUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Enter a name"
    }
    val text: LiveData<String> = _text

    fun getNumberOfSwitches() {
        viewModelScope.launch {

               // getNumberOfSwitchesUseCase.getNumber()

        }
    }
}