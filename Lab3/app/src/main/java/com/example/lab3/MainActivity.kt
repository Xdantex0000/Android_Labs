package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    override fun onFragmentInteraction(result: String) {
        var fragment2 = supportFragmentManager.findFragmentById(R.id.file_fragment) as FileFragment
        if(fragment2.isInLayout){
            fragment2.setCurrentResult(result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}