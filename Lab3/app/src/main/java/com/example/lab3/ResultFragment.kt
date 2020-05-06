package com.example.lab3

import android.content.Intent
import kotlinx.android.synthetic.main.result_fragment.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
        file_content.setOnClickListener{
            val sec_activity = Intent(this.context, FileFragment::class.java);
        }
    }


}