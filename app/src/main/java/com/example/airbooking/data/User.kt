package com.example.airbooking.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "passwordHash") val passwordHash: String?
)
