package io.github.diegoflassa.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    @Json(name = ID)
    var id: Int = 0,

    @Json(name = POST_ID)
    var postId: Int = 0,

    @Json(name = NAME)
    var name: String = "",

    @Json(name = EMAIL)
    var email: String = "",

    @Json(name = BODY)
    var body: String = "",
) : Parcelable {

    companion object {
        const val ID = "id"
        const val POST_ID = "postId"
        const val NAME = "name"
        const val EMAIL = "email"
        const val BODY = "body"
    }
}
