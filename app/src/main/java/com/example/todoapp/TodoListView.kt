package com.example.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class TodoListView : AppCompatActivity() {

    lateinit var listOfTodo:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_view)

        listOfTodo = findViewById(R.id.todo_listView)


//        var db = DBHandeller(this)

        val TAG = "Test"
//        var emList = listOf<String>()
//        val data = db.readActivities()

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

//        val arrayAdapter: ArrayAdapter<*>
//        Log.d(TAG, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::After Array Adaptor Creation")
//        arrayAdapteryAdapter = MyAdapterpter
        listOfTodo.adapter = MyAdapter(this)


    }

    class MyAdapter(context: Context):BaseAdapter(){

        private val mContext: Context

        init {
            mContext = context
        }

        var db = DBHandeller(mContext)
        val data = db.readActivities()

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            var layoutInflater = LayoutInflater.from(mContext)
            var row = layoutInflater.inflate(R.layout.row_main, viewGroup, false)



            val todoName =row.findViewById<TextView>(R.id.actvity_name)
            todoName.text = data.get(position).todo.toString()

            return row

        }

        override fun getItem(position: Int): Any {
            return ""
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return data.size
        }

    }

}