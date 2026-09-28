package cc.shinemoon.domain.usecase

import cc.shinemoon.domain.model.UserModel
import cc.shinemoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class SearchUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(query: String): Flow<Result<List<UserModel>>>{
        return repository.search(query)
    }

}