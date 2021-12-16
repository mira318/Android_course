package com.example.hw_6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Notes")
        setContentView(R.layout.activity_detailed)
        val textView = findViewById<TextView>(R.id.detailed_text)
        val detailedText = NotesRepository.getNotesList()[0].text
        textView.text = detailedText
    }

    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, DetailedActivity::class.java)
        }
    }
}