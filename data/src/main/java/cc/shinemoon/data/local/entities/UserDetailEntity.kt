package cc.shinemoon.data.local.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("user_details")
data class UserDetailEntity(
    @PrimaryKey val login: String = "",
    val id: Long = -1L,
    val avatarUrl: String = "",
    val name: String = "",
    val bio: String = "",
    val email: String = "",
    val location: String = "",
    val company: String = "",
    val blog: String = "",
    val publicRepos: Int,
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    val createdAt: String = "",
    val updatedAt: String = "",
    val htmlUrl: String = "",
    val type: String = "",
    val siteAdmin: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)
