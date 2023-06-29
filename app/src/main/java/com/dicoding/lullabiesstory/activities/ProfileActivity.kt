package com.dicoding.lullabiesstory.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.travelee.lullabies.R


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}