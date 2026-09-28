package cc.shinemoon.data.mapper

import cc.shinemoon.data.dto.searches.UserItemDto
import cc.shinemoon.data.local.entities.UserEntity
import cc.shinemoon.domain.model.UserModel
import org.junit.Assert.assertEquals
import org.junit.Test

class UserDtoMapperTest {

    @Test
    fun userItemDto_mapsToUserModel() {
        val dto = UserItemDto(
            id = 42L,
            login = "octocat",
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            bio = "GitHub user",
            publicRepos = 12,
            followers = 34,
            following = 5,
            type = "User",
            siteAdmin = false
        )

        assertEquals(
            UserModel(
                id = 42L,
                login = "octocat",
                avatarUrl = "https://example.com/avatar.png",
                htmlUrl = "https://github.com/octocat",
                bio = "GitHub user",
                publicRepos = 12,
                followers = 34,
                following = 5,
                type = "User",
                siteAdmin = false
            ),
            dto.toUserModel()
        )
    }

    @Test
    fun userItemDto_mapsToEntityAndEntityMapsToModel() {
        val dto = UserItemDto(
            id = 7L,
            login = "octocat",
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            bio = "GitHub user",
            publicRepos = 8,
            followers = 9,
            following = 2,
            type = "User",
            siteAdmin = true
        )
        val actualEntity = dto.toUserEntity()
        val expectedEntity = UserEntity(
            id = 7L,
            login = "octocat",
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            bio = "GitHub user",
            publicRepos = 8,
            followers = 9,
            following = 2,
            type = "User",
            siteAdmin = true,
            lastUpdated = actualEntity.lastUpdated
        )

        assertEquals(expectedEntity, actualEntity)
        assertEquals(actualEntity.toUserModel(), dto.toUserModel())
    }
}