import data.Comment
import data.Post
import org.junit.Test
import service.WallService
import exception.PostNotFoundException

import org.junit.Assert.*
import org.junit.Before

class WallServiceKtTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        // Arrange
        val post = Post(0, 0, 0, 0, "Happy birthday", null)

        // Act
        val result = WallService.add(post)

        // Assert
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateFailed() {
        // Arrange
        val post = Post(100, 0, 0, 0, "Happy birthday", null)
        WallService.add(post)
        WallService.add(post)

        // Act
        val result = WallService.update(post)

        // Assert
        assertEquals(false, result)
    }

    @Test
    fun updateSuccess() {
        // Arrange
        val post = Post(0, 0, 0, 0, "Happy birthday", null)
        WallService.add(post);
        val postNew = Post(1, 1, 1, 0, "Happy birthday!!!", null)

        // Act
        val result = WallService.update(postNew)

        // Assert
        assertEquals(true, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // Arrange
        val post = Post(0, 0, 0, 0, "Happy birthday", null)
        WallService.add(post);
        val comment = Comment(0, 0, "Thanks!", 0)

        // Act
        WallService.createComment(100, comment)
    }

    @Test
    fun shouldNotThrow() {
        // Arrange
        val post = Post(0, 0, 0, 0, "Happy birthday", null)
        WallService.add(post);
        val comment = Comment(0, 0, "Thanks!", 0)

        // Act
        val result = WallService.createComment(1, comment)

        // Assert
        assertEquals(1, result.id)
    }
}