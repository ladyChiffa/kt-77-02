package data

data class Post (
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val copyright: Copyright?,
    val isFavourite: Boolean = false,
    val markedAsAds: Boolean = false,
    val likes: Likes = Likes(),
    val views: Views = Views()
)
