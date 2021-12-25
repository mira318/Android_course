package com.example.hw_6

import android.animation.Animator
import android.animation.AnimatorSet
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.icu.util.TimeUnit.values
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Notes")
        setContentView(R.layout.activity_main)

        val cardView = findViewById<androidx.cardview.widget.CardView>(R.id.card_view)
        val dateText = findViewById<TextView>(R.id.data_string)
        val cardText = findViewById<TextView>(R.id.card_text)
        val NotesList = NotesRepository.getNotesList()
        dateText.text = NotesList[0].date
        cardText.text = NotesList[0].text

        cardView.setOnFocusChangeListener{ view, hasFocus ->
            if(hasFocus){
                cardView.setCardBackgroundColor(ContextCompat.getColor(applicationContext,
                    R.color.focused_grey)
                )
            } else {
                cardView.setCardBackgroundColor(ContextCompat.getColor(applicationContext,
                    R.color.white)
                )
            }
        }

        cardView.setOnClickListener{
            cardView.setCardBackgroundColor(ContextCompat.getColor(applicationContext,
                R.color.clicked_blue)
            )
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                val intent = DetailedActivityLandscape.getIntent(this)
                startActivity(intent)
            } else {
                // ориентация может быть ещё неопределённой
                    // пусть в этих случаях тоже будет портретная
                val intent = DetailedActivityPortrait.getIntent(this)
                startActivity(intent)
            }

        }
    }

    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}