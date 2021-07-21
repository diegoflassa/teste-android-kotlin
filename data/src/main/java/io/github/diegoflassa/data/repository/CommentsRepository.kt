package io.github.diegoflassa.data.repository

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.diegoflassa.data.entities.Comment
import io.github.diegoflassa.data.interfaces.CommentsDao
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class CommentsRepository {

    private val tag: String? = CommentsRepository::class.simpleName
    private val patientsBaseUrl = "https://jsonplaceholder.typicode.com"

    fun getAllById(postId: Int): Observable<List<Comment>> {
        val okHttpClient = OkHttpClient()
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(patientsBaseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        Log.i(tag, "CommentsRepository.getAll")
        return retrofit.create(CommentsDao::class.java)
            .getAllById(postId)
    }
}
