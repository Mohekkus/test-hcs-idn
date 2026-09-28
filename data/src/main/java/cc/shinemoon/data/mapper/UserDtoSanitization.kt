package cc.shinemoon.data.mapper

import cc.shinemoon.data.dto.searches.UserItemDto
import cc.shinemoon.data.local.entities.UserEntity
import cc.shinemoon.domain.model.UserModel

fun UserItemDto.toUserModel(): UserModel =
    UserModel(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        publicRepos = publicRepos,
        followers = followers,
        following = following,
        type = type,
        siteAdmin = siteAdmin,
        bio = bio
    )

fun UserItemDto.toUserEntity(): UserEntity =
    UserEntity(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        bio = bio,
        htmlUrl = htmlUrl,
        publicRepos = publicRepos,
        followers = followers,
        following = following,
        type = type,
        siteAdmin = siteAdmin
    )

fun UserEntity.toUserModel(): UserModel =
    UserModel(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        publicRepos = publicRepos,
        followers = followers,
        following = following,
        type = type,
        siteAdmin = siteAdmin,
        bio = bio,
    )

fun List<UserItemDto>.dtoToListUserModel(): List<UserModel> =
    map { it.toUserModel() }

fun List<UserItemDto>.toListUserEntity(): List<UserEntity> =
    map { it.toUserEntity() }

fun List<UserEntity>.toListUserModel(): List<UserModel> =
    map { it.toUserModel() }