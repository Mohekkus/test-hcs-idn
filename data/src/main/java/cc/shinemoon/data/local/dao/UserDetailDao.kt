package cc.shinemoon.data.local.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import cc.shinemoon.data.local.entities.UserDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDetailDao {

    @Query("SELECT * FROM user_details WHERE login = :login")
    fun observeUserDetail(login: String): Flow<UserDetailEntity?>

    @Query("SELECT * FROM user_details WHERE login = :login")
    suspend fun getUserDetail(login: String): UserDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDetail(userDetail: UserDetailEntity)

    @Query("DELETE FROM user_details WHERE login = :login")
    suspend fun deleteUserDetail(login: String)
}