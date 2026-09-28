package cc.shinemoon.data.dto.searches

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class TextMatchesItem(

	@Json(name="fragment")
	val fragment: String = "",

	@Json(name="object_url")
	val objectUrl: String = "",

	@Json(name="object_type")
	val objectType: String = "",

	@Json(name="property")
	val property: String = "",

	@Json(name="matches")
	val matches: List<MatchesItem>
)