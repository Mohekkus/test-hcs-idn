package cc.shinemoon.data.di

import android.content.Context
import androidx.room3.Room
import cc.shinemoon.data.local.UserDatabase
import cc.shinemoon.data.local.dao.UserDao
import cc.shinemoon.data.local.dao.UserDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "github_users.db"
        ).build()

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.userDao()

    @Provides
    fun provideUserDetailDao(database: UserDatabase): UserDetailDao = database.userDetailDao()
}