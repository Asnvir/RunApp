package com.example.runapp.other

import android.graphics.Color
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY

object Constants {

    const val DIRECTORY_PICTURES = "Pictures"
    const val IMAGE_JPEG = "image/jpeg"
    const val ZERO_TIME = "00:00:00:00"

    const val RUNNING_DATABASE_NAME = "running_db"
    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"


    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1

    const val LOCATION_UPDATE_INTERVAL = 5000L
    const val FASTEST_LOCATION_INTERVAL = 2000L
    const val LOCATION_REQUEST_PRIORITY = PRIORITY_HIGH_ACCURACY

    const val POLYLINE_COLOR = Color.GREEN
    const val POLYLINE_WIDTH = 10f
    const val MAP_ZOOM = 18f

    const val TIMER_UPDATE_INTERVAL = 50L

    const val START_TXT = "Start"
    const val STOP_TXT = "Stop"

    const val RUN_SAVED_SUCCESSFULLY = "Run saved successfully"

    const val SHARED_PREF_NAME = "sharedPref"
    const val KEY_FIRST_TIME_TOGGLE = "KEY_FIRST_TIME_TOGGLE"
    const val KEY_NAME = "KEY_NAME"
    const val KEY_WEIGHT = "KEY_WEIGHT"

}