package cc.shinemoon.data.mapper

import cc.shinemoon.data.dto.detail.UserDetailResponseDto
import cc.shinemoon.data.local.entities.UserDetailEntity
import cc.shinemoon.domain.model.UserDetailModel

fun UserDetailResponseDto.toModel() = UserDetailModel(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    publicRepos = publicRepos,
    followers = followers,
    following = following,
    type = type,
    siteAdmin = siteAdmin,
    publicGists = publicGists,
    bio = bio
)

fun UserDetailResponseDto.toEntity() = UserDetailEntity(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    publicRepos = publicRepos,
    followers = followers,
    following = following,
    type = type,
    siteAdmin = siteAdmin,
    publicGists = publicGists,
    bio = bio
)

fun UserDetailEntity.toModel() = UserDetailModel(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    publicRepos = publicRepos,
    followers = followers,
    following = following,
    type = type,
    siteAdmin = siteAdmin,
    publicGists = publicGists,
    bio = bio
)


