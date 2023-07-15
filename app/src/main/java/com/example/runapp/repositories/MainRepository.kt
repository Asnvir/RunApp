package com.example.runapp.repositories

import com.example.runapp.database.Run
import com.example.runapp.database.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val runDao: RunDAO
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistanceInMeters() = runDao.getAllRunsSortedByDistanceInMeters()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getAllRunsSortedByAvgSpeedInKMH() = runDao.getAllRunsSortedByAvgSpeedInKMH()

    fun getTotalAvgSpeedInKMH() = runDao.getTotalAvgSpeedInKMH()

    fun getTotalDistanceInMeters() = runDao.getTotalDistanceInMeters()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
}