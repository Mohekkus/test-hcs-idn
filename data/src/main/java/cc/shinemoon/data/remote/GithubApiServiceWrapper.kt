package cc.shinemoon.data.remote

import cc.shinemoon.data.dto.detail.UserDetailResponseDto
import cc.shinemoon.data.dto.searches.SearchResponseDto
import cc.shinemoon.data.remote.util.Resources
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubApiServiceWrapper @Inject constructor(
    private val apiService: GithubApiService
) {
    suspend fun search(query: String): Resources<SearchResponseDto> {
        return try {
            val response = apiService.search(query)
            Resources.Success(response)
        } catch (e: HttpException) {
            Resources.Error(
                message = "HTTP ${e.code()}: ${e.message()}",
                data = null
            )
        } catch (e: IOException) {
            Resources.Error(
                message = "Network error: Please check your internet connection",
                data = null
            )
        } catch (e: Exception) {
            Resources.Error(
                message = "Unexpected error: ${e.localizedMessage}",
                data = null
            )
        }
    }

    suspend fun getDetail(username: String): Resources<UserDetailResponseDto> {
        return try {
            val response = apiService.getUserDetail(username)
            Resources.Success(response)
        } catch (e: HttpException) {
            Resources.Error(
                message = "HTTP ${e.code()}: ${e.message()}",
                data = null
            )
        } catch (e: IOException) {
            Resources.Error(
                message = "Network error: Please check your internet connection",
                data = null
            )
        } catch (e: Exception) {
            Resources.Error(
                message = "Unexpected error: ${e.localizedMessage}",
                data = null
            )
        }
    }
}