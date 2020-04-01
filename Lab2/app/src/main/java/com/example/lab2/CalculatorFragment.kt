package com.example.lab2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.calculator_fragment.*

interface OnFragmentInteractionListener {
    fun onFragmentInteraction(result: String)
}

class CalculatorFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.calculator_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonChecker()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun buttonChecker()
    {
        button.setOnClickListener{
            calculate()
        }
    }

    fun calculate(){
        var fst_number = 0
        var sec_number = 0
        var numbers_filled = true
        var result_D: Double = 0.0;
        var result: Int = 0;

        if(first_number.text.length==0 || second_number.text.length==0){
            listener?.onFragmentInteraction("You didn't write the numbers!")
            numbers_filled = false
        }else{
            fst_number = first_number.text.toString().toInt()
            sec_number = second_number.text.toString().toInt()
        }

        if(radioButton1.isChecked == true){
            result = fst_number + sec_number
            listener?.onFragmentInteraction("The result of calculation: ${result.toString()}")
        }
        if(radioButton2.isChecked == true){
            result = fst_number - sec_number
            listener?.onFragmentInteraction("The result of calculation: ${result.toString()}")
        }
        if(radioButton3.isChecked == true){
            result = fst_number * sec_number
            listener?.onFragmentInteraction("The result of calculation: ${result.toString()}")
        }
        if(radioButton4.isChecked == true){
            result_D = fst_number.toDouble() / sec_number.toDouble()
            listener?.onFragmentInteraction("The result of calculation: ${result_D.toString()}")
        }
        if(numbers_filled==true && radioButton1.isChecked != true && radioButton2.isChecked != true && radioButton3.isChecked != true && radioButton4.isChecked != true)       {
            listener?.onFragmentInteraction("You didn't choose the operator!")
        }
    }
}