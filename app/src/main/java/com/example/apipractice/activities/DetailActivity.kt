package com.example.apipractice.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apipractice.R
import com.example.apipractice.models.GameDeals

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val deal = intent.getParcelableExtra<GameDeals>(EXTRA_DEAL)
        Log.d("Create", "onCreate: " + deal)
    }

    companion object {
        val EXTRA_DEAL = "deal"
    }
}