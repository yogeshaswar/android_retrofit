package com.example.kotlinandroid.models;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class JavaDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "users.db";

    // dao
    public abstract UserDAO userDAO();

    // class variable
    public JavaDatabase INSTANCE;

    // method to access Database class variable
    public synchronized JavaDatabase getINSTANCE(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, JavaDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
}

//
//@Database(entities = arrayOf(Todo::class), version = 1
//abstract class TodoDatabase : RoomDatabase() {
//abstract fun getTodoDao(): TodoDao
//
//        companion object {
//@Volatile
//private var INSTANCE: TodoDatabase? = null
//
//        fun getDatabase(context: Context): TodoDatabase {
//        return INSTANCE ?: synchronized(this) {
//        val instance = Room.databaseBuilder(
//        context.applicationContext,
//        TodoDatabase::class.java,
//        DATABASE_NAME
//        ).build()
//
//        INSTANCE = instance
//        instance
//        }
//        }
//        }
//
//        })
