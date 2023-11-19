package com.example.airbooking.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity()
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "username") val username: String? = null ,
    @ColumnInfo(name = "passwordHash") val passwordHash: String? = null,
    @ColumnInfo(name = "profilePictureUri") val profilePictureUri: String? = null
)


