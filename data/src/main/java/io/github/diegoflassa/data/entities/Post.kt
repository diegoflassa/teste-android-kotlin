package io.github.diegoflassa.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    @Json(name = ID)
    var id: Int = 0,

    @Json(name = USER_ID)
    var userId: Int = 0,

    @Json(name = TITLE)
    var title: String = "",

    @Json(name = BODY)
    var body: String = "",
) : Parcelable {

    companion object {
        const val ID = "id"
        const val USER_ID = "userId"
        const val TITLE = "title"
        const val BODY = "body"
    }
}
