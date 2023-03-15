package com.pr7.Kotlin_Retrofit_JsonPlaceHolder

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*



class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var postAdapter: PostAdapter
    var arraylist=ArrayList<Post>()
    var arraylistphotos=ArrayList<PostsPhotoItem>()
    lateinit var api: Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)

        api=RetrofitInstance.retrofit.create(Api::class.java)



    }

    fun insertPost(){
        val post=Post(userId = 0, id = 0, title = "Pr77777", body = "Dota All Stars")
        val call: Call<Post> = api.insertPosts(post)

        call.enqueue(object :Callback<Post>{
            override fun onResponse(
                call: Call<Post>,
                response: Response<Post>
            ) {
                //Natija
                if (response.isSuccessful){
                    val post=response.body()
                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message.toString(),Toast.LENGTH_SHORT).show()

            }
        })
    }

    fun getCommentWithId(){
        val call: Call<ArrayList<Post>> = api.getCommentWithId2(3)
        call.enqueue(object :Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                //Natija
                if (response.code()==200){
                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
                    arraylist=response.body()!!
                    //textView.text=arrayList?.get(0)?.title
                    recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
                    postAdapter=PostAdapter(this@MainActivity,arraylist)
                    recyclerView.adapter=postAdapter


                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }


    fun getAllPhotos(){
        val call: Call<ArrayList<PostsPhotoItem>> = api.getAllPhotos()
        call.enqueue(object :Callback<ArrayList<PostsPhotoItem>>{
            override fun onResponse(
                call: Call<ArrayList<PostsPhotoItem>>,
                response: Response<ArrayList<PostsPhotoItem>>
            ) {
                if (response.code()==200){
                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
                    arraylistphotos=response.body()!!

//                    recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
//                    postAdapter=PostAdapter(this@MainActivity,arraylistphotos)
//                    recyclerView.adapter=postAdapter
                }

            }

            override fun onFailure(call: Call<ArrayList<PostsPhotoItem>>, t: Throwable) {

            }
        })
    }

    fun getAllPosts(){
        val call: Call<ArrayList<Post>> = api.getAllPosts()

        //Zapros go
        call.enqueue(object :Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                //Natija
                if (response.code()==200){
                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
                    arraylist=response.body()!!
                    //textView.text=arrayList?.get(0)?.title
                    recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
                    postAdapter=PostAdapter(this@MainActivity,arraylist)
                    recyclerView.adapter=postAdapter


                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }
}