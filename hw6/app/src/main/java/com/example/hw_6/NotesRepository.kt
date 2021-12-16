package com.example.hw_6

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object NotesRepository {
    private val NOTES_LIST = mutableListOf<Note>()
    fun init(context: Context){
        try{
            val date: String
            val text: String
            BufferedReader(InputStreamReader(context.assets.open("dates.txt"))).use{
                    reader->
                date = reader.readLine()
            }
            BufferedReader(InputStreamReader(context.assets.open("notes_texts.txt"))).use{
                    reader->
                text = reader.readText()
            }
            NOTES_LIST.add(Note(date, text))
        } catch(e: IOException){
            e.printStackTrace()
        }
        println("read the list")
    }

    fun getNotesList(): List<Note>{
        return NOTES_LIST.toList()
    }
}