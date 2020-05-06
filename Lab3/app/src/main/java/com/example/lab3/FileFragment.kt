package com.example.lab3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_file.*
import java.io.File

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FileFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FileFragment : Fragment() {

    var currentTextResult = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_file, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        writeToFileSetup()
        openFileSetup()
    }

    fun setCurrentResult(result: String){
        currentTextResult = result
    }

    fun writeToFileSetup(){
        saveButton.setOnClickListener{
            if(!fileName.text.toString().trim().equals(""))
            {
                    context!!.openFileOutput(fileName.text.toString(), Context.MODE_PRIVATE).use {
                        it.write(currentTextResult.toByteArray())
                    }

                    resultFileFragmentText.text = "Calculation result is written to ${fileName.text.toString()}.txt"
            }
            else
            {
                resultFileFragmentText.text = "You didn't write file name"
            }
        }
    }

    fun openFileSetup(){
        openButton.setOnClickListener{
            if(!fileName.text.toString().trim().equals(""))
            {
                // data/user/0/com.example.lab2/files/filename.txt
                val file = File(context!!.filesDir, fileName.text.toString())
                var fileExists = file.exists()
                if(fileExists){
                    val contents = file.readText() // Read file

                    val intent = Intent(this.context, FileoutputActivity::class.java)
                    intent.putExtra("text",contents)
                    intent.putExtra("filename",fileName.text.toString())
                    startActivity(intent)
                }
                else{
                    resultFileFragmentText.text = "File does not exist"
                }
            }
            else{
                resultFileFragmentText.text = "You didn't write file name"
            }
        }

    }

}
