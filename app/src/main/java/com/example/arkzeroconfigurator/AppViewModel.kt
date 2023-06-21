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


    var trimId by mutableStateOf('g')
    fun updateTrim(id: Char){
        trimId = id
    }

    var paintId by mutableStateOf('s')  // 0 - 10
    fun updatePaint(id: Char){
        paintId = id
    }

    var interiorId by mutableStateOf('c')
    fun updateInterior(id: Char){
        interiorId  = id
    }

    /*
    var options by mutableStateOf(arrayOf(false, false, false, false, false, false, false, false, false))

    fun updateOption(id: Int){
        options[id] = !options[id]
    }

     */

    var opt0 by mutableStateOf(false)
    var opt1 by mutableStateOf(false)
    var opt2 by mutableStateOf(false)
    var opt3 by mutableStateOf(false)
    var opt4 by mutableStateOf(false)
    var opt5 by mutableStateOf(false)
    var opt6 by mutableStateOf(false)
    var opt7 by mutableStateOf(false)
    var opt8 by mutableStateOf(false)

    fun updateOption(id: Int){
        when(id){
            0 -> {opt0 = !opt0}
            1 -> {opt1 = !opt1}
            2 -> {opt2 = !opt2}
            3 -> {opt3 = !opt3}
            4 -> {opt4 = !opt4}
            5 -> {opt5 = !opt5}
            6 -> {opt6 = !opt6}
            7 -> {opt7 = !opt7}
            8 -> {opt8 = !opt8}
        }
    }


}