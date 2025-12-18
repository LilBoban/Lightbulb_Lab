package com.example.lightbulblab.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lightbulblab.data.domain.ControlLightUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val controlLightUseCase: ControlLightUseCase
) : ViewModel() {

    private val _statusMessage = MutableLiveData<String>()
    val statusMessage = _statusMessage

    fun toggleLamp(turnOn : Boolean){
        viewModelScope.launch {
            try {
                controlLightUseCase.switchLight(turnOn)
                _statusMessage.value = if (turnOn) "Включено" else "Выключено"
            }
            catch (e: Exception){
                _statusMessage.value = "Error ${e.message}"
            }
        }
    }

    fun changeColor(colorName : String){
        viewModelScope.launch {
            try {
                controlLightUseCase.changeColor(colorName)
                _statusMessage.value = "Цвет изменен на ${colorName}"
            }
            catch (e: Exception){
                _statusMessage.value = "Error color change"
            }
        }
    }
}
