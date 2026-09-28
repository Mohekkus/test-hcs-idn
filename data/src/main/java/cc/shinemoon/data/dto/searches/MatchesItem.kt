package cc.shinemoon.data.dto.searches

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class MatchesItem(

	@Json(name="indices")
	val indices: List<Int>,

	@Json(name="text")
	val text: String = ""
)