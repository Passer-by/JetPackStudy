package com.mieya.jetpackstudy.flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.math.log

class FlowViewModel:ViewModel() {
    private val TAG = "FlowViewModel"
    val coldFlow= MutableSharedFlow<Int>(
        replay = 0,
        extraBufferCapacity = 0
    )
    val baseFlow= flow{
        emit(1)
        Log.i(TAG, "baseFlow:1 ")
    }
    fun startFlow(){
        viewModelScope.launch {
            coldFlow.emit(10)
            delay(1000)
            Log.i(TAG, "startFlow: ")
            startFlow()
        }
    }


}