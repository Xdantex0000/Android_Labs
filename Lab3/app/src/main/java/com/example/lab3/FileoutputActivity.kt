package com.example.lab3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_file_content.*

class FileoutputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_content)
        val text = intent.getStringExtra("text")
        val filename = intent.getStringExtra("filename")
        SetOutputTextSetup(text, filename)
    }

    fun SetOutputTextSetup(text: String, filename: String){
        Content.text = "Read from ${filename} choice was: ${text}"
    }

}