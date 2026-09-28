package cc.shinemoon.data.local.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("users")
data class UserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val avatarUrl: String,
    val bio: String?,
    val htmlUrl: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
    val type: String?,
    val siteAdmin: Boolean,
    val lastUpdated: Long = System.currentTimeMillis()
)
