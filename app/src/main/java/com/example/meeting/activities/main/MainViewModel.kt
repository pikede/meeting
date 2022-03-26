package com.example.meeting.activities.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meeting.models.Sports
import com.example.meeting.service.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val api by lazy { RetrofitHelper.getRetrofit() }

    val sportsLiveData = MutableLiveData<Sports>()
    val errorMessage = MutableLiveData<String>()

    fun getSports() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val sportsResponse = api.getAllSports()

                if (sportsResponse.isSuccessful) {
                    sportsResponse.body()?.let {
                        sportsLiveData.postValue(it)
                        Log.d("sports:", "$it")
                    }
                } else {
                    errorMessage.postValue("Error getting sports")
                }

            } catch (e: Exception) {
                errorMessage.postValue(e.message ?: e.localizedMessage)
                Log.d("error:", e.message ?: e.localizedMessage)
            }
        }
    }

}