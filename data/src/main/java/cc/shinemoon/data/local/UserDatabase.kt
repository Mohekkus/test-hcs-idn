package cc.shinemoon.data.local

import androidx.room3.Database
import androidx.room3.RoomDatabase
import cc.shinemoon.data.local.dao.UserDao
import cc.shinemoon.data.local.dao.UserDetailDao
import cc.shinemoon.data.local.entities.UserDetailEntity
import cc.shinemoon.data.local.entities.UserEntity

@Database(
    entities = [UserEntity::class, UserDetailEntity::class],
    version = 1,
    exportSchema = true
)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userDetailDao(): UserDetailDao
}