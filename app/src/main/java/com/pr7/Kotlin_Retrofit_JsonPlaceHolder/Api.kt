package com.pr7.Kotlin_Retrofit_JsonPlaceHolder


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    fun getAllPosts():Call<ArrayList<Post>>
    //https://jsonplaceholder.typicode.com/photos
    @GET("photos")
    fun getAllPhotos():Call<ArrayList<PostsPhotoItem>>

    //https://jsonplaceholder.typicode.com/posts/1/comments
    @GET("/posts/{id}/comments")
    fun getCommentWithId(@Path("id") id:Int):Call<ArrayList<Post>>

    //https://jsonplaceholder.typicode.com/comments?postId=1
    @GET("comments")
    fun getCommentWithId2(@Query("postId") postId:Int):Call<ArrayList<Post>>


    //https://jsonplaceholder.typicode.com/posts
    @POST("posts")
    fun insertPosts(@Body post: Post):Call<Post>



}