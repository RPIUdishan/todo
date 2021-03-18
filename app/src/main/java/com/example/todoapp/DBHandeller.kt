package com.example.todoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ACTIVITY_DB"
val TABLE_NAME = "TODO_TABLE"
val COL_ID = "id"
val COL_ACTIVITY = "activity"

class DBHandeller(var context: Context): SQLiteOpenHelper(context,DATABASE_NAME, null, 1 ){
    override fun onCreate(db: SQLiteDatabase?) {
        //create table
        val createTable = "CREATE TABLE "+ TABLE_NAME + "( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_ACTIVITY + " VARCHAR(250))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertActivity(todoActivity: TodoActivity){

        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_ACTIVITY, todoActivity.todo)
        var result = db.insert(TABLE_NAME, null, cv)

        if(result == -1.toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context, "Succeed", Toast.LENGTH_LONG).show()
        }

    }

    fun readActivities(): MutableList<TodoActivity>{
        var list: MutableList<TodoActivity> = ArrayList()
        var db = this.readableDatabase
        val readQuery = "SELECT * FROM " + TABLE_NAME
        var result = db.rawQuery(readQuery, null)
        if(result.moveToFirst()){
            do{
                var todoAc = TodoActivity()
                todoAc.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                todoAc.todo = result.getString(result.getColumnIndex(COL_ACTIVITY)).toString()

                list.add(todoAc)
            } while(result.moveToNext())


        }

        result.close()
        db.close()
        return list
    }

}