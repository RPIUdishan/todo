package com.example.todoapp

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class TodoListView : AppCompatActivity() {


    lateinit var listOfTodo:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_view)

        listOfTodo = findViewById(R.id.todo_listView)

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

            val todoName = row.findViewById<TextView>(R.id.actvity_name)
            todoName.text = data.get(position).todo.toString()

            var btnDet = row.findViewById<Button>(R.id.btnDel)
            btnDet.setOnClickListener(){
                db.deleteActivity(data.get(position).id)
            }

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