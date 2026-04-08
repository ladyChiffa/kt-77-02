package data

//=======================================================================
// Media classes
data class PhotoLink (
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)
data class Photo (
    val id: Int,
    val ownerId: Int,
    val text: String = "",
    val albumId: Int? = null,
    val sizes: Array<PhotoLink> = emptyArray()
)

data class Audio (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val artist: String,
    val url: String,
    val albumId: Int? = null
)

data class Video (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url: String,
    val description: String = "",
    val views: Int = 0,
    val albumId: Int? = null
)

data class File (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url: String,
    val size: Int
)

data class Coordinates (
    val longitude: Int,
    val latitude: Int
)
data class Geotag (
    val type: String,
    val coordinates: Coordinates
)

//=======================================================================
// Attachment classes
abstract class Attachment (
    open val type: String
)

data class PhotoAttachment (
    override val type: String,
    val photo: Photo
) : Attachment(type)

data class AudioAttachment (
    override val type: String,
    val audio: Audio
) : Attachment(type)
data class VideoAttachment (
    override val type: String,
    val video: Video
) : Attachment(type)
data class FileAttachment (
    override val type: String,
    val file: File
) : Attachment(type)
data class GeoAttachment (
    override val type: String,
    val geotag: Geotag
) : Attachment(type)