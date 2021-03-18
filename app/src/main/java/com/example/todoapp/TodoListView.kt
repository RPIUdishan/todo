package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView

class TodoListView : AppCompatActivity() {

    lateinit var listOfTodo:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_view)

        listOfTodo = findViewById(R.id.todo_listView)


        var db = DBHandeller(this)

        val TAG = "Test"
//        var emList = listOf<String>()
        val data = db.readActivities()

        val tstList = listOf<String>("Mango", "Apple", "Banana")
//        var x = data.get(2).
//        Log.d(TAG, data.get(1).todo.toString())
//        Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After data")
//        var itr = data.listIterator()
//        Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After Iteration")

//        for (element in data){
//            Log.d(TAG, element.todo)
//            emList.toMutableList().add(element.todo)
//        }

//        while(itr.hasNext()){
//            Log.d(TAG, itr.next().todo.toString())
//            Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Before Looping")
//            emList.toMutableList().add(itr.next().todo.toString())
//            Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After Looping")
//        }
//        Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After Array While Execution")

//        Log.d(TAG, "QWERTY "+emList.toString())

        val arrayAdapter: ArrayAdapter<*>
        Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After Array Adaptor Creation")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tstList)
        listOfTodo.adapter = arrayAdapter


    }

}