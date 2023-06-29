package com.dicoding.lullabiesstory.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.travelee.lullabies.R

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Story Details"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val stories = intent.getParcelableExtra<Stories>(EXTRA_ITEM)
        val actionShare: Button = findViewById(R.id.action_share)

        if (stories != null){
            with(binding){
                tvTitle.text = stories.title
                Glide
                    .with(this@DetailActivity)
                    .load(stories.image)
                    .into(ivImage)
                tvAuthor.text= stories.author
                tvReleaseDate.text = stories.releaseDate
                tvGenre.text = tvGenre.text
                tvMinutes.text = tvMinutes.text
                Glide
                    .with(this@DetailActivity)
                    .load(baseline_star_24)
                    .into(ivRating)
                tvRating.text = stories.rate
                tvGenres.text = stories.genre
                tvMinutes.text = stories.readingtime
                tvDesc.text = tvDesc.text
                tvDescription.text = stories.content
            }
        }

        actionShare.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, "I found this short story is exciting and help me having a good sleep, it is  ${stories!!.title}, check on ${stories.link}")
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Share \"${stories!!.title}\" on : "))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_ITEM = "extra_item"
    }
}