package com.dicoding.lullabiesstory

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.lullabiesstory.activities.DetailActivity

class StoriesAdapter (private val storiesList: List<Stories>) :
    RecyclerView.Adapter<StoriesAdapter.ListViewHolder>() {
    //Assign Data
    class ListViewHolder(private val binding: StoriesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stories: Stories) {
            with(binding) {
                Glide
                    .with(itemView.context)
                    .load(stories.image)
                    .into(ivImage)
                tvTitle.text = stories.title
                tvAuthor.text = stories.author
                tvReadingtime.text = stories.readingtime
                Glide
                    .with(itemView.context)
                    .load(R.drawable.baseline_star_24)
                    .into(ivRating)
                tvRating.text = stories.rate

            }
            itemView.setOnClickListener{
                val moveToDetail = Intent(itemView.context, DetailActivity::class.java)
                moveToDetail.putExtra(DetailActivity.EXTRA_ITEM, stories)
                itemView.context.startActivity(moveToDetail)
            }
        }
    }

    // Bind Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            StoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // Ammount of Data
    override fun getItemCount(): Int {
        return storiesList.size
    }

    // Get Data Position
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(storiesList[position])
    }
}