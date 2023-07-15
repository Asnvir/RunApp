package com.example.runapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.runapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel(){

    val totalTimeRun = mainRepository.getTotalTimeInMillis()
    val totalDistanceInMeters = mainRepository.getTotalDistanceInMeters()
    val totalCaloriesBurned = mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeedInKMH = mainRepository.getTotalAvgSpeedInKMH()

    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()
}