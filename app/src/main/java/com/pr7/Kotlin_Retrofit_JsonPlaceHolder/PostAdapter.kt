package com.pr7.Kotlin_Retrofit_JsonPlaceHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapter constructor(
    val context:Context,
    val arrayList: ArrayList<Post>
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view=LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textView.text="${arrayList.get(position).body}"
        //Glide.with(context).load(arrayList.get(position).url).into(holder.imageView)
    }

    override fun getItemCount(): Int =arrayList.size



    class PostViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val textView:TextView=itemview.findViewById(R.id.textviewresp)
        val imageView:ImageView=itemview.findViewById(R.id.imageviewresp)
    }
}