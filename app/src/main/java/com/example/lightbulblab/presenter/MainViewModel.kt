package com.example.lightbulblab.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lightbulblab.domain.ChangeBrightnessUseCase
import com.example.lightbulblab.domain.ChangeColorUseCase
import com.example.lightbulblab.domain.ControlLightUseCase
import com.example.lightbulblab.domain.SwitchLightUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val switchLightUseCase: SwitchLightUseCase,
    private val changeColorUseCase: ChangeColorUseCase,
    private val changeBrightnessUseCase: ChangeBrightnessUseCase
) : ViewModel() {

    private val _statusMessage = MutableLiveData<String>()
    val statusMessage: LiveData<String> = _statusMessage

    fun toggleLamp(turnOn : Boolean){
        viewModelScope.launch {
            try {
                switchLightUseCase(turnOn)
                _statusMessage.value = if (turnOn) "Включено" else "Выключено"
            } catch (e: Exception){
                _statusMessage.value = "Error ${e.message}"
            }
        }
    }

    fun changeColor(color: String) {
        viewModelScope.launch {
            try {
                changeColorUseCase(color)
                _statusMessage.value = "Цвет: $color"
            } catch (e: Exception) {
                _statusMessage.value = "Ошибка цвета"
            }
        }
    }

    fun setBrightness(level: Int) {
        viewModelScope.launch {
            try {
                changeBrightnessUseCase(level)
                _statusMessage.value = "Яркость: $level"
            } catch (e: Exception) {
                _statusMessage.value = "Ошибка яркости"
            }
        }
    }
}
