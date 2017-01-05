package com.project.milos.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miloš on 1/2/2017.
 */

public class TodoDAO {

    private SQLiteDatabase db;
    private TodoSQLiteHelper dbHelper;

    public TodoDAO(Context context) {
        dbHelper = new TodoSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    public void close() {
        db.close();
    }

    public void createTodo(String todoText) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("todo", todoText);

        db.insert("todos", null, contentValues);
    }

    public void deleteTodo(int todoId) {
        db.delete("todos", "_id = " + todoId, null);
    }

    public List<Todo> getTodos() {
        List<Todo> todoList = new ArrayList<Todo>();
        String[] tableColumns = new String[] {"_id", "todo"};
        Cursor cursor = db.query("todos", tableColumns, null, null, null, null, null);

        while (!cursor.isAfterLast()) {
            Todo todo = new Todo();

            todo.setId(cursor.getInt(0));
            todo.setText(cursor.getString(1));

            todoList.add(todo);

            cursor.moveToNext();
        }
        return todoList;
    }
}
