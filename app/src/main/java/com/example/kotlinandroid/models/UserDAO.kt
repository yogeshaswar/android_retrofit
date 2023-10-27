package com.example.kotlinandroid.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    //void deleteUser(UserModel user);

    @Insert
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM userTable")
    fun getAllUsers(): List<User>


}