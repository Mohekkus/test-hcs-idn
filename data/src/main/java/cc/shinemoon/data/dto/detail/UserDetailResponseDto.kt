package cc.shinemoon.data.dto.detail

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class UserDetailResponseDto(

	@Json(name="gists_url")
	val gistsUrl: String,

	@Json(name="repos_url")
	val reposUrl: String,

	@Json(name="user_view_type")
	val userViewType: String,

	@Json(name="two_factor_authentication")
	val twoFactorAuthentication: String,

	@Json(name="following_url")
	val followingUrl: String,

	@Json(name="twitter_username")
	val twitterUsername: String,

	@Json(name="bio")
	val bio: String,

	@Json(name="created_at")
	val createdAt: String,

	@Json(name="login")
	val login: String,

	@Json(name="type")
	val type: String,

	@Json(name="blog")
	val blog: String,

	@Json(name="private_gists")
	val privateGists: String,

	@Json(name="total_private_repos")
	val totalPrivateRepos: String,

	@Json(name="subscriptions_url")
	val subscriptionsUrl: String,

	@Json(name="updated_at")
	val updatedAt: String,

	@Json(name="site_admin")
	val siteAdmin: String,

	@Json(name="disk_usage")
	val diskUsage: String,

	@Json(name="collaborators")
	val collaborators: String,

	@Json(name="company")
	val company: String,

	@Json(name="owned_private_repos")
	val ownedPrivateRepos: String,

	@Json(name="id")
	val id: String,

	@Json(name="public_repos")
	val publicRepos: String,

	@Json(name="gravatar_id")
	val gravatarId: String,

	@Json(name="plan")
	val plan: Plan,

	@Json(name="email")
	val email: String,

	@Json(name="organizations_url")
	val organizationsUrl: String,

	@Json(name="notification_email")
	val notificationEmail: String,

	@Json(name="hireable")
	val hireable: String,

	@Json(name="starred_url")
	val starredUrl: String,

	@Json(name="followers_url")
	val followersUrl: String,

	@Json(name="public_gists")
	val publicGists: String,

	@Json(name="url")
	val url: String,

	@Json(name="received_events_url")
	val receivedEventsUrl: String,

	@Json(name="ldap_dn")
	val ldapDn: String,

	@Json(name="followers")
	val followers: String,

	@Json(name="avatar_url")
	val avatarUrl: String,

	@Json(name="events_url")
	val eventsUrl: String,

	@Json(name="business_plus")
	val businessPlus: String,

	@Json(name="html_url")
	val htmlUrl: String,

	@Json(name="following")
	val following: String,

	@Json(name="name")
	val name: String,

	@Json(name="location")
	val location: String,

	@Json(name="node_id")
	val nodeId: String
)