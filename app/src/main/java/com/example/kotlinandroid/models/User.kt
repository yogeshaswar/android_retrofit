package com.example.kotlinandroid.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class User(@PrimaryKey(autoGenerate = true) var id: Int,
                @ColumnInfo(name = "User Name") var userName: String,
                @ColumnInfo(name = "Password") var password: String)