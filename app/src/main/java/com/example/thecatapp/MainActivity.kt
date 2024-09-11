package com.example.thecatapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BuildCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.thecatapp.api.RetrofitService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val retrofitClient by lazy {
        RetrofitService.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCats()
    }

    private fun getCats() {
        lifecycleScope.launch {
            val cats = retrofitClient.getCatsImages()
            cats.forEach { cat ->
                Log.d("TEST--", "Cat: $cat")
            }
        }
    }

}