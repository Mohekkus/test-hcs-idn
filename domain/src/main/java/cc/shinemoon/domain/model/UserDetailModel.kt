package cc.shinemoon.domain.model

data class UserDetailModel(
    val id: Long,
    val login: String,
    val avatarUrl: String,
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
    val siteAdmin: Boolean,
    val hireable: Boolean = false
)
