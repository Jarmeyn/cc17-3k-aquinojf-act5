package com.example.myartspace

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private val paintingNames = arrayOf(
        "Liberty leaded the people",
        "Starry Night",
        "The man with the golden helmet",
        "The scream",
        "Water Lily"
    )

    private val authors = arrayOf(
        "Vincent Van Gogh",
        "Claude Monet",
        "Edvard Munch",
        "Rembrantd",
        "Eugene Delacroix"
    )

    private val years = arrayOf(
        "1889",
        "1899",
        "1893",
        "1650",
        "1830"
    )

    private val images = arrayOf(
        R.drawable.liberty_leading_the_people,
        R.drawable.starry_night,
        R.drawable.the_masn_with_the_golden_helmet,
        R.drawable.the_scream,
        R.drawable.water_lily
    )

    private var currentIndex = 0


    private lateinit var pictureView: ImageView
    private lateinit var nameView: TextView
    private lateinit var authorView: TextView
    private lateinit var yearView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pictureView = findViewById(R.id.image)
        nameView = findViewById(R.id.name)
        authorView = findViewById(R.id.author)
        yearView = findViewById(R.id.year)

        val prevButton: Button = findViewById(R.id.prevButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        updateGallery()

        prevButton.setOnClickListener {
            currentIndex = getPreviousIndex(currentIndex)
            updateGallery()
        }

        nextButton.setOnClickListener {
            currentIndex = getNextIndex(currentIndex)
            updateGallery()
        }
    }

    private fun getPreviousIndex(index: Int): Int {
        return when {
            index > 0 -> index - 1
            else -> paintingNames.size - 1
        }
    }

    private fun getNextIndex(index: Int): Int {
        return when {
            index < paintingNames.size - 1 -> index + 1
            else -> 0
        }
    }

    private fun updateGallery() {
        pictureView.setImageResource(images[currentIndex])
        nameView.text = paintingNames[currentIndex]
        authorView.text = authors[currentIndex]
        yearView.text = years[currentIndex]
    }
}
