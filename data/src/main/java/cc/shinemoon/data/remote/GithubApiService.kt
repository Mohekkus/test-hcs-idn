package cc.shinemoon.data.remote

import cc.shinemoon.data.dto.detail.UserDetailResponseDto
import cc.shinemoon.data.dto.searches.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("search/user")
    suspend fun search(
        @Query("q") query: String,
        @Query("per_page") pageCount: Int,
        @Query("page") pageIndex: Int
    ): SearchResponseDto

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): UserDetailResponseDto
}