package com.example.runapp.other

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.runapp.R
import com.example.runapp.database.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CustomMarkerView(
    private val runs: List<Run>,
    context: Context,
    layoutId: Int
) : MarkerView(context, layoutId) {

    private var tvDate: TextView = findViewById(R.id.tvDateMW)
    private var tvDuration: TextView = findViewById(R.id.tvDurationMW)
    private var tvAvgSpeed: TextView = findViewById(R.id.tvAvgSpeedMW)
    private var tvDistance: TextView = findViewById(R.id.tvDistanceMW)
    private var tvCaloriesBurned: TextView = findViewById(R.id.tvCaloriesBurnedMW)


    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)

        if (e == null) {
            return
        }

        val currentRunId = e.x.toInt()

        val run = runs[currentRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }

        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        val formattedDate = dateFormat.format(calendar.time)
        tvDate.text = formattedDate

        val avgSpeed = "${run.avgSpeedInKMH}km/h"
        tvAvgSpeed.text = avgSpeed

        val distanceInKm = "${run.distanceInMeters / 1000f}km"
        tvDistance.text = distanceInKm

        val formattedDuration = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
        tvDuration.text = formattedDuration

        val caloriesBurned = "${run.caloriesBurned}kcal"
        tvCaloriesBurned.text = caloriesBurned
    }


    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }
}