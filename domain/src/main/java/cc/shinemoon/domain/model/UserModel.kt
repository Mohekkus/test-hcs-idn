package cc.shinemoon.domain.model

data class UserModel(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
    val type: String?,
    val siteAdmin: Boolean
)
