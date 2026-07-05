package service

import data.Comment
import data.Post
import exception.PostNotFoundException

object WallService {
    private var posts = emptyArray<Post>()
    private var idNext = 0;
    private var comments = emptyArray<Comment>()
    private var idNextComment = 0;

    fun clear () {
        posts = emptyArray()
        idNext = 0
        idNextComment = 0
    }

    fun add (post: Post) : Post {
        val newPost = post.copy(id = ++idNext)
        posts += newPost
        return newPost
    }

    fun update (postNew: Post) : Boolean {
        for( (index, post) in posts.withIndex() ) {
            if (post.id == postNew.id) {
                posts[index] = postNew
                return true
            }
        }
        return false
    }

    fun findById(id: Int) : Post? {
        for( post in posts ) {
            if (post.id == id) {
                return post
            }
        }
        return null
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val post = findById(postId) ?: throw PostNotFoundException("No post with id $postId")
        val newComment = comment.copy(id = ++idNextComment)
        comments += newComment
        return newComment
    }

}