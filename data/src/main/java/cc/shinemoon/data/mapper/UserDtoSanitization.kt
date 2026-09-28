package cc.shinemoon.data.mapper

import cc.shinemoon.data.dto.searches.UserItemDto
import cc.shinemoon.data.local.entities.UserEntity
import cc.shinemoon.domain.model.UserModel

fun UserItemDto.toModel(): UserModel =
    UserModel(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        publicRepos = publicRepos,
        followers = followers,
        following = following,
        type = type,
        siteAdmin = siteAdmin
    )

fun UserItemDto.toEntity(): UserEntity =
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

fun UserEntity.toModel(): UserModel =
    UserModel(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl,
        publicRepos = publicRepos,
        followers = followers,
        following = following,
        type = type,
        siteAdmin = siteAdmin
    )

fun List<UserItemDto>.toModel(): List<UserModel> =
    map { it.toModel() }

fun List<UserItemDto>.toEntity(): List<UserEntity> =
    map { it.toEntity() }

fun List<UserEntity>.toModel(): List<UserModel> =
    map { it.toModel() }