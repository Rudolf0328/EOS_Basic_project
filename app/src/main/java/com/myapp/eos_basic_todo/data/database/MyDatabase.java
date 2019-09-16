package com.myapp.eos_basic_todo.data.database;

import android.content.Context;

import com.myapp.eos_basic_todo.data.dao.TodoDao;
import com.myapp.eos_basic_todo.data.entity.TodoItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {TodoItem.class})
public abstract class MyDatabase extends RoomDatabase {
    abstract public TodoDao todoDao();

    private static MyDatabase myDatabase;

    public static MyDatabase getInstance(Context context) {
        //main에서 사용할 수 있게 해준다.
        if(myDatabase == null) {
            myDatabase = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "myDatabase.db").allowMainThreadQueries().build();
        }
        return myDatabase;
    }
}

//껐다켜도 저장이 된다.
