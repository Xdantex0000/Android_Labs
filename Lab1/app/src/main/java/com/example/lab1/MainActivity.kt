package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toastMe(view: View){
        var fst_number = 0
        var sec_number = 0
        var numbers_filled = true
        var result_D: Double = 0.0;
        var result: Int = 0;

        if(first_number.text.length==0 || second_number.text.length==0){
            val myToast = Toast.makeText(this, "You didn't write the numbers!", Toast.LENGTH_SHORT)
            numbers_filled = false
            myToast.show()
        }else{
            fst_number = first_number.text.toString().toInt()
            sec_number = second_number.text.toString().toInt()
        }

        if(radioButton1.isChecked == true){
            result = fst_number + sec_number
            val myToast = Toast.makeText(this, "The result of calculation: "+result.toString() , Toast.LENGTH_SHORT)
            myToast.show()
        }
        if(radioButton2.isChecked == true){
            result = fst_number - sec_number
            val myToast = Toast.makeText(this, "The result of calculation: "+result.toString() , Toast.LENGTH_SHORT)
            myToast.show()
        }
        if(radioButton3.isChecked == true){
            result = fst_number * sec_number
            val myToast = Toast.makeText(this, "The result of calculation: "+result.toString() , Toast.LENGTH_SHORT)
            myToast.show()
        }
        if(radioButton4.isChecked == true){
            result_D = fst_number.toDouble() / sec_number.toDouble()
            val myToast = Toast.makeText(this, "The result of calculation: "+result_D.toString() , Toast.LENGTH_SHORT)
            myToast.show()
        }
        if(numbers_filled==true && radioButton1.isChecked != true && radioButton2.isChecked != true && radioButton3.isChecked != true && radioButton4.isChecked != true)       {
            val myToast = Toast.makeText(this, "You didn't choose the operator!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }
}
