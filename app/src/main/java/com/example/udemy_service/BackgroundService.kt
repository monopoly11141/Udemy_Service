package com.example.udemy_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.udemy_service.MainActivity.Companion.NAME
import com.example.udemy_service.MainActivity.Companion.TAG
import com.example.udemy_service.MainActivity.Companion.TOTAL_MARKS

class BackgroundService : Service() {


    init {
        Log.i(TAG, "Service created.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started.")
        val name = intent?.getStringExtra(NAME)
        val totalMarks = intent?.getIntExtra(TOTAL_MARKS, 0)
        Log.i(TAG, "Name : $name, totalMarks : $totalMarks")

        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG, "Service destroying...")

        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null


}