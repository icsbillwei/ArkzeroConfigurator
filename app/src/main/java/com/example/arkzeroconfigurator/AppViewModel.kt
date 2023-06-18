package com.example.arkzeroconfigurator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    // icons
    var iconId by mutableStateOf(0)   // 0 - 5

    fun updateNavbar(id: Int){
        iconId = id
        // println(iconId)
    }


    var trimId by mutableStateOf('z')
    fun updateTrim(id: Char){
        trimId = id
    }

    var paintId by mutableStateOf('s')  // 0 - 10
    fun updatePaint(id: Char){
        paintId = id
    }

    var wheelId by mutableStateOf('m')
    fun updateWheel(id: Char){
        wheelId = id
    }

    var interiorId by mutableStateOf('b')
    fun updateInterior(id: Char){
        interiorId  = id
    }


}