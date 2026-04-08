package data

//=======================================================================
// Media classes
class PhotoLink (
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)
class Photo (
    val id: Int,
    val ownerId: Int,
    val text: String = "",
    val albumId: Int? = null,
    val sizes: Array<PhotoLink> = emptyArray()
)

class Audio (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val artist: String,
    val url: String,
    val albumId: Int? = null
)

class Video (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url: String,
    val description: String = "",
    val views: Int = 0,
    val albumId: Int? = null
)

class File (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url: String,
    val size: Int
)

class Coordinates (
    val longitude: Int,
    val latitude: Int
)
class Geotag (
    val type: String,
    val coordinates: Coordinates
)


//=======================================================================
// Attachment classes
abstract class Attachment (
    val type: String
)

class PhotoAttachment (
    type: String,
    val photo: Photo
)
class AudioAttachment (
    type: String,
    val audio: Audio
)
class VideoAttachment (
    type: String,
    val video: Video
)
class FileAttachment (
    type: String,
    val file: File
)
class GeoAttachment (
    type: String,
    val geotag: Geotag
)