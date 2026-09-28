package cc.shinemoon.data.repository

import cc.shinemoon.data.local.dao.UserDao
import cc.shinemoon.data.local.dao.UserDetailDao
import cc.shinemoon.data.mapper.toEntity
import cc.shinemoon.data.mapper.toModel
import cc.shinemoon.data.remote.GithubApiService
import cc.shinemoon.data.remote.GithubApiServiceWrapper
import cc.shinemoon.data.remote.util.Resources
import cc.shinemoon.domain.model.UserDetailModel
import cc.shinemoon.domain.model.UserModel
import cc.shinemoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val service: GithubApiServiceWrapper,
    private val userDao: UserDao,
    private val userDetailDao: UserDetailDao
): UserRepository {

    override fun search(query: String): Flow<Result<List<UserModel>>> = flow {
        val cachedEntities = userDao.getAllUsers().first()
        if (cachedEntities.isNotEmpty()) {
            emit(Result.success(cachedEntities.toModel()))
        }

        when (val result = service.search(query)) {
            is Resources.Success -> {
                result.data?.items?.let {
                    userDao.insertUsers(it.toEntity())
                    emit(
                        Result.success(
                            it.toModel()
                        )
                    )
                }

            }
            is Resources.Error -> {
                if (cachedEntities.isEmpty()) {
                    emit(Result.failure(Exception(result.message)))
                } else {
                    emit(Result.failure(Exception("Showing cached data. ${result.message}")))
                }
            }
        }
    }

    override fun userDetail(name: String): Flow<Result<UserDetailModel>> = flow {
        val cachedEntity = userDetailDao.getUserDetail(name)
        cachedEntity?.let {
            emit(
                Result.success(
                    it.toModel()
                )
            )
        }

        when (val result = service.getDetail(name)) {
            is Resources.Success -> {
                result.data?.let {
                    userDetailDao.insertUserDetail(it.toEntity())
                    emit(
                        Result.success(
                            it.toModel()
                        )
                    )
                }
            }

            is Resources.Error -> {
                if (cachedEntity == null) {
                    emit(Result.failure(Exception(result.message ?: "Network error")))
                } else {
                    emit(Result.failure(Exception("Offline mode. ${result.message}")))
                }
            }
        }
    }

    override suspend fun refreshUserDetail(name: String): Result<UserDetailModel> {
        return when (val result = service.getDetail(name)) {
            is Resources.Success<*> -> {
                result.data?.let {
                    userDetailDao.insertUserDetail(
                        it.toEntity()
                    )
                    Result.success(it.toModel())
                } ?: run {
                    Result.failure(Exception(result.message ?: "Returned data null"))
                }
            }

            is Resources.Error -> {
                Result.failure(Exception(result.message ?: "Refresh failed"))
            }
        }
    }


}