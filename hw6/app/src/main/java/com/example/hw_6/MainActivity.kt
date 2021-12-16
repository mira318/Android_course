package com.example.hw_6

import android.content.Intent.getIntent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        cardView.setOnClickListener{
            val intent = DetailedActivity.getIntent(this)
            startActivity(intent)
        }
    }
}