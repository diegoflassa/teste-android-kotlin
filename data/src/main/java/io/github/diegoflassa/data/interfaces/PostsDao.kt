package io.github.diegoflassa.data.interfaces

import io.github.diegoflassa.data.entities.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PostsDao {
    @GET("/posts/")
    fun getAll(
    ): Observable<List<Post>>
}
