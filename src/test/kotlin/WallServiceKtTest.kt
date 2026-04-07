import data.Post
import org.junit.Test
import service.WallService

import org.junit.Assert.*

class WallServiceKtTest {
    @Test
    fun add() {
        // Arrange
        WallService.clear()
        val post = Post(0, 0, 0, 0, "Happy birthday", null)

        // Act
        val result = WallService.add(post)

        // Assert
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateFailed() {
        // Arrange
        WallService.clear()
        val post = Post(100, 0, 0, 0, "Happy birthday", null)

        // Act
        val result = WallService.update(post)

        // Assert
        assertEquals(false, result)
    }

    @Test
    fun updateSuccess() {
        // Arrange
        WallService.clear()
        val post = Post(0, 0, 0, 0, "Happy birthday", null)
        WallService.add(post);
        val postNew = Post(1, 1, 1, 0, "Happy birthday!!!", null)

        // Act
        val result = WallService.update(postNew)

        // Assert
        assertEquals(true, result)
    }
}