package cc.shinemoon.domain.usecase

import cc.shinemoon.domain.model.UserDetailModel
import cc.shinemoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserUseCase(
    private val repository: UserRepository
) {
    fun detail(name: String): Flow<Result<UserDetailModel>> =
        repository.userDetail(name)

    suspend fun refresh(name: String) {
        repository.refreshUserDetail(name)
    }
}