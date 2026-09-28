package cc.shinemoon.domain.repository

import cc.shinemoon.domain.model.UserDetailModel
import cc.shinemoon.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun search(query: String): Flow<Result<List<UserModel>>>
    fun userDetail(name: String): Flow<Result<UserDetailModel>>
    suspend fun refreshUserDetail(name: String): Result<UserDetailModel>
}