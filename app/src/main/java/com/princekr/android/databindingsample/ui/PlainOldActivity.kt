package com.princekr.android.databindingsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.princekr.android.databindingsample.R

class PlainOldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.plain_activity)
    }
}