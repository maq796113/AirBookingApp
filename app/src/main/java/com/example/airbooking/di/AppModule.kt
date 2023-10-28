package com.example.airbooking.di

import android.app.Application
import androidx.room.Room
import com.example.airbooking.UserUseCases
import com.example.airbooking.data.UserRepository
import com.example.airbooking.data.UserRepositoryImplementation
import com.example.airbooking.data.UserRoomDatabase
import com.example.airbooking.usecase.DeleteUser
import com.example.airbooking.usecase.EnterUser
import com.example.airbooking.usecase.UniqueUsername
import com.example.airbooking.usecase.ValidateUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Volatile
    var INSTANCE: UserRoomDatabase? = null

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserRoomDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                app,
                UserRoomDatabase::class.java,
                UserRoomDatabase.DATABASE_NAME
            ).build()
            INSTANCE = instance
            instance
        }
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserRoomDatabase): UserRepository {
        return UserRepositoryImplementation(db.userDAO)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository): UserUseCases {
        return UserUseCases(
            deleteUser = DeleteUser(repository),
            uniqueUsername = UniqueUsername(repository),
            validateUser = ValidateUser(repository),
            enterUser = EnterUser(repository)
        )
    }
}