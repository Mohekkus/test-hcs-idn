package cc.shinemoon.data.dto.searches

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class UserItemDto(

    @Json(name = "repos_url")
    val reposUrl: String = "",

    @Json(name = "gists_url")
    val gistsUrl: String = "",

    @Json(name = "user_view_type")
    val userViewType: String = "",

    @Json(name = "following_url")
    val followingUrl: String = "",

    @Json(name = "created_at")
    val createdAt: String = "",

    @Json(name = "bio")
    val bio: String = "",

    @Json(name = "login")
    val login: String = "",

    @Json(name = "type")
    val type: String = "",

    @Json(name = "blog")
    val blog: String = "",

    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String = "",

    @Json(name = "score")
    val score: Int = 0,

    @Json(name = "updated_at")
    val updatedAt: String = "",

    @Json(name = "site_admin")
    val siteAdmin: Boolean,

    @Json(name = "company")
    val company: String = "",

    @Json(name = "id")
    val id: Long = -1L,

    @Json(name = "public_repos")
    val publicRepos: Int = 0,

    @Json(name = "gravatar_id")
    val gravatarId: String = "",

    @Json(name = "email")
    val email: String = "",

    @Json(name = "organizations_url")
    val organizationsUrl: String = "",

    @Json(name = "hireable")
    val hireable: Boolean,

    @Json(name = "starred_url")
    val starredUrl: String = "",

    @Json(name = "followers_url")
    val followersUrl: String = "",

    @Json(name = "public_gists")
    val publicGists: Int = 0,

    @Json(name = "url")
    val url: String = "",

    @Json(name = "received_events_url")
    val receivedEventsUrl: String = "",

    @Json(name = "followers")
    val followers: Int = 0,

    @Json(name = "avatar_url")
    val avatarUrl: String = "",

    @Json(name = "events_url")
    val eventsUrl: String = "",

    @Json(name = "html_url")
    val htmlUrl: String = "",

    @Json(name = "following")
    val following: Int = 0,

    @Json(name = "text_matches")
    val textMatches: List<TextMatchesItem>,

    @Json(name = "name")
    val name: String = "",

    @Json(name = "location")
    val location: String = "",

    @Json(name = "node_id")
    val nodeId: String = "",

    @Json(name = "suspended_at")
    val suspendedAt: String = ""
)