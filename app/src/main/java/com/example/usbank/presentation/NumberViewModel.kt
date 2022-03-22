package com.example.usbank.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usbank.data.NumberRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NumberViewModel : ViewModel() {

    private var _numbers: MutableLiveData<List<Int>> = MutableLiveData(emptyList())
    val numbers: LiveData<List<Int>> get() = _numbers

    init {
        getRandomNumbers()
    }

    // Gets random number. Adds number to list only if api call was successful.
    private fun getRandomNumbers() {
        viewModelScope.launch {
            while (true) {
                delay(1000L)
                val result = NumberRepository.getRandomNumber()
                if (result.isSuccess) {
                    addLatestItem(result.getOrNull())
                }
            }
        }
    }

    // Will remove oldest item and insert new item from list
    // Updates LiveData with new list
    private fun addLatestItem(num: Int?) {
        if (num == null) return
        if (numbers.value?.isEmpty() == true) {
            _numbers.postValue(listOf(num))
            return
        }

        val tmpList = numbers.value as MutableList
        if (tmpList.size == 10) {
            tmpList.removeAt(0)
            tmpList.add(num)
            _numbers.value = tmpList
            return
        }
        tmpList.add(num)
        _numbers.value = tmpList
    }
}