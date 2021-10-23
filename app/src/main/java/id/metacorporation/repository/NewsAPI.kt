package id.metacorporation.repository

import id.metacorporation.models.Posts
import retrofit2.Call
import retrofit2.http.GET

interface NewsAPI {
    @GET("posts")
    fun getPosts() : Call<ArrayList<Posts>>
}