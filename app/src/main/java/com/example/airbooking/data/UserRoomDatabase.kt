package com.example.airbooking.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1,
//    exportSchema = true,
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)
//    ]
)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract val userDAO: UserDAO

    companion object {

        const val DATABASE_NAME = "user-db"


    }
}