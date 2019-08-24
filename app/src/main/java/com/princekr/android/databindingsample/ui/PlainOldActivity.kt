package com.princekr.android.databindingsample.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.princekr.android.databindingsample.R
import com.princekr.android.databindingsample.data.Popularity
import com.princekr.android.databindingsample.data.SimpleViewModel

/**
 * Plain old activity with lots of problems to fix.
 */
class PlainOldActivity : AppCompatActivity() {

    // Obtain view model from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.plain_activity)

        // TODO: Explicitly setting initial values is a bad pattern. We'll fix that.
        updateName()
    }

    /**
     * So much findViewById! We'll fix that with Data Binding.
     */
    private fun updateName() {
        findViewById<TextView>(R.id.plain_name).text = viewModel.name
        findViewById<TextView>(R.id.plain_lastname).text = viewModel.lastName
    }

    /**
     * This method has many problems:
     * - it's calling findViewById multiple times.
     * - It has unstable logic.
     * - It's updating two views when called even if they're not changing.
     */
    private fun updateLikes() {
        findViewById<TextView>(R.id.likes).text = viewModel.likes.toString()
        findViewById<ProgressBar>(R.id.progressBar).progress = (viewModel.likes * 100 / 5).coerceAtLeast(100)
        val image = findViewById<ImageView>(R.id.imageView)

        //val color = ge
        image.setImageDrawable(getDrawablePopularity(viewModel.popularity, this))
    }

    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }
}