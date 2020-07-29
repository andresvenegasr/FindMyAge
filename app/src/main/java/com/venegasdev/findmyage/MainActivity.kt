package com.venegasdev.findmyage

import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Year

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val txtAge: EditText = findViewById(R.id.txtAge)
        val tvLegendAge: TextView = findViewById(R.id.tvLegendAge)
        val tvAge: TextView = findViewById(R.id.tvAge)

        btnCalculate.setOnClickListener {
            tvAge.visibility = View.INVISIBLE
            tvLegendAge.visibility = View.INVISIBLE

            if(txtAge?.text?.length!! != 4){
                Toast.makeText(this, "Type a full year", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(txtAge?.text?.toString()!!.toInt() > LocalDateTime.now().year){
                Toast.makeText(this, "Oh!!! it seems like you doesn't born yet!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(txtAge?.text?.toString()!!.toInt() < 1900){
                Toast.makeText(this, "Oh!!! You are very old!! Soon you will die, ups.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var age = LocalDateTime.now().year - txtAge?.text?.toString()!!.toInt()

            tvAge.text  = age.toString()
            tvAge.visibility = View.VISIBLE

            tvLegendAge.text = "${age.toString()} is your age! 😜"
            tvLegendAge.visibility = View.VISIBLE
        }
    }
}