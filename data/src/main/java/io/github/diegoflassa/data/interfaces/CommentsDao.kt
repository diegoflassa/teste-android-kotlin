package io.github.diegoflassa.data.interfaces

import io.github.diegoflassa.data.entities.Comment
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentsDao {

    @GET("/posts/{post_id}/comments")
    fun getAllById(
        @Path("post_id")id: Int,
    ): Observable<List<Comment>>
}
