package com.chekincompose.ok.features.lesson_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Lesson2ViewModel : ViewModel() {
    val clickCountLiveData = MutableLiveData(0)

    fun incrementCount() {
        clickCountLiveData.value?.let { count ->
            clickCountLiveData.value = count + 1
        }
    }

    fun resetCount() {
        clickCountLiveData.value = 0
    }
}