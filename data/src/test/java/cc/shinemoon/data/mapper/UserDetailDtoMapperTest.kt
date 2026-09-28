package cc.shinemoon.data.mapper

import cc.shinemoon.data.dto.detail.UserDetailResponseDto
import cc.shinemoon.data.local.entities.UserDetailEntity
import cc.shinemoon.domain.model.UserDetailModel
import org.junit.Assert.assertEquals
import org.junit.Test

class UserDetailDtoMapperTest {

    @Test
    fun userDetailDto_mapsToModelAndEntity() {
        val dto = UserDetailResponseDto(
            bio = "GitHub user",
            login = "octocat",
            type = "User",
            siteAdmin = false,
            id = 42L,
            publicRepos = 12,
            publicGists = 3,
            followers = 34,
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            following = 5,
            nodeId = "node-42"
        )
        val expectedModel = UserDetailModel(
            id = 42L,
            login = "octocat",
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            publicRepos = 12,
            publicGists = 3,
            followers = 34,
            following = 5,
            type = "User",
            siteAdmin = false,
            bio = "GitHub user"
        )
        val actualEntity = dto.toEntity()
        val expectedEntity = UserDetailEntity(
            id = 42L,
            login = "octocat",
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/octocat",
            publicRepos = 12,
            publicGists = 3,
            followers = 34,
            following = 5,
            type = "User",
            siteAdmin = false,
            bio = "GitHub user",
            lastUpdated = actualEntity.lastUpdated
        )

        assertEquals(expectedModel, dto.toModel())
        assertEquals(expectedEntity, actualEntity)
        assertEquals(expectedModel, actualEntity.toModel())
    }

    @Test
    fun nullableDetailFields_defaultToEmptyStrings() {
        val dto = UserDetailResponseDto(
            siteAdmin = false,
            id = 1L,
            publicRepos = 0,
            publicGists = 0,
            followers = 0,
            following = 0,
            nodeId = "node-1"
        )

        val model = dto.toModel()

        assertEquals("", model.login)
        assertEquals("", model.avatarUrl)
        assertEquals("", model.htmlUrl)
        assertEquals("", model.type)
        assertEquals("", model.bio)
    }
}