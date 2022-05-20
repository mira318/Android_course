package com.example.hw_6

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hw_6.DetailedActivityLandscape.Companion.getIntent

class DetailedActivityLandscape : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Notes")
        setContentView(R.layout.activity_detailed_landscape)
        val textView = findViewById<TextView>(R.id.detailed_text_landscape)
        val detailedText = NotesRepository.getNotesList()[0].text
        textView.text = detailedText
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val intent = DetailedActivityPortrait.getIntent(this)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = MainActivity.getIntent(this)
        startActivity(intent)
    }

    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, DetailedActivityLandscape::class.java)
        }
    }
}