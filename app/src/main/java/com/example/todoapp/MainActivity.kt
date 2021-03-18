package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dateText: TextView
    lateinit var etActivity: EditText
    lateinit var btnEnter: Button
    lateinit var btnShowAll: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateText = findViewById(R.id.tvDate)

        etActivity = findViewById(R.id.etactivity)

        btnEnter = findViewById(R.id.btn_activity)
        btnShowAll = findViewById(R.id.btn_showAll)

        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance()
        val formatedDate = formatter.format(date)

        dateText.text = formatedDate

        val db = DBHandeller(this)
        btnEnter.setOnClickListener {
            if(etActivity.text.toString().isNotBlank() or etActivity.text.toString().isNotEmpty()){
                var act = TodoActivity(etActivity.text.toString())
                db.insertActivity(act)
                etActivity.text.clear()
            } else{
                Toast.makeText(this, "Please Enter Activity", Toast.LENGTH_SHORT).show()
            }
        }

        btnShowAll.setOnClickListener(){
            var intent = Intent(this, TodoListView::class.java)
            startActivity(intent)
        }


    }
}