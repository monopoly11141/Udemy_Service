package com.example.udemy_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.udemy_service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, BackgroundService::class.java)
        serviceIntent.putExtra(NAME, "Alex")
        serviceIntent.putExtra(TOTAL_MARKS, 89)

        binding.btnStart.setOnClickListener {
            Log.i(TAG, "Starting Service")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.i(TAG, "Stopping Service")
            stopService(serviceIntent)
        }
    }

    companion object {
        const val TAG = "MYTAG"
        const val NAME = "NAME"
        const val TOTAL_MARKS = "TOTAL_MARKS"
    }
}