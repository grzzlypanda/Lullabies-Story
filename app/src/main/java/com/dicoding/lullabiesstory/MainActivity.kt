package com.dicoding.lullabiesstory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.travelee.lullabies.R
import com.travelee.lullabies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Lullabies App"

        val storiesAdapter = StoriesAdapter(StoriesData.getStoriesList())

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvStories.layoutManager = layoutManager

        with(binding){
            rvStories.adapter = storiesAdapter
            rvStories.setHasFixedSize(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.topbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_account -> {
                val launchAbout = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(launchAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}