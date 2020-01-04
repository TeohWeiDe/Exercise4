package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pickDateBtn.setOnClickListener{
            val dpd = DatePickerDialog (this, DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDay ->
                val realY = mYear;
                val age = Calendar.getInstance().get(Calendar.YEAR) - realY
                textAge.setText("" + age)
                if(age > 55 ){
                    textBasicSaving.setText("0")
                }
                else if(age > 50){
                    textBasicSaving.setText("228000")
                }
                else if(age > 45){
                    textBasicSaving.setText("165000")
                }
                else if(age > 40){
                    textBasicSaving.setText("116000")
                }
                else if(age > 35){
                    textBasicSaving.setText("78000")
                }
                else if(age > 30){
                    textBasicSaving.setText("50000")
                }
                else if(age > 25){
                    textBasicSaving.setText("29000")
                }
                else if(age > 20){
                    textBasicSaving.setText("14000")
                }
                else if(age > 15){
                    textBasicSaving.setText("5000")
                }
                else{
                    textBasicSaving.setText("0")
                }
                textBirthday.setText("" + mDay + "/" + mMonth + 1 + "/" + mYear)
            }, year, month, day)


            dpd.show()

        }

        calculate.setOnClickListener{
            val bs = findViewById<TextView>(R.id.textBasicSaving)
            val ac1 = findViewById<EditText>(R.id.totalAccount1)

            val weight = bs.text.toString().toDouble()
            val height = ac1.text.toString().toDouble()
            val total = (weight - height) * 0.3

            totalInves.setText(String.format("Invesment: RM %.2f", total))
        }
    }
}
