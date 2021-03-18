package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowTodo : AppCompatActivity() {

    lateinit var listView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_todo)

        listView = findViewById(R.id.list)

        var db = DBHandeller(this)

        var data = db.readActivities()
        listView.text = ""
        for (i in 0..(data.size - 1)) {
            listView.append(data.get(i).id.toString() + " " + data.get(i).todo.toString() + "\n")

        }
    }
}