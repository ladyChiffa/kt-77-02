package service

import data.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var idNext = 0;

    fun clear () {
        posts = emptyArray()
        idNext = 0
    }

    fun add (post: Post) : Post {
        idNext ++;
        val newPost = post.copy(id = idNext);
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

}