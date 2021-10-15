package com.example.age_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{view ->
            printAge(view)
        }
    }

    private fun printAge(view: View){
        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                view, year, month, day->
            val selectedDate = "$day/${month + 1}/$year"

            var textview = findViewById<TextView>(R.id.settext)
            textview.text = selectedDate

            var dob = Calendar.getInstance()
            dob.set(year,month,day)

            var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
                    age--
                }

            var outputText = findViewById<TextView>(R.id.output)
            outputText.text = "Your are $age year old."

                                                                }
            ,year
            ,month
            ,day).show()
    }
}