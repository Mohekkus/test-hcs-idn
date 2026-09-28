package cc.shinemoon.data.dto.detail

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class Plan(

	@Json(name="private_repos")
	val privateRepos: String,

	@Json(name="name")
	val name: String,

	@Json(name="collaborators")
	val collaborators: String,

	@Json(name="space")
	val space: String
)