package com.example.modul5lesson9.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson9.R
import com.example.modul5lesson9.addapter.FeedAdapter
import com.example.modul5lesson9.model.Feed
import com.example.modul5lesson9.model.Post
import com.example.modul5lesson9.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds : ArrayList<Feed>) {
        recyclerView.adapter = FeedAdapter(this, feeds)
    }

    private fun getAllFeeds() : ArrayList<Feed>{
        val stories : ArrayList<Story> = ArrayList()

       for (i in 0..10)
           stories.add(Story(R.drawable.img_profile, "Mansur Mirzayev$i"))

        val feeds : ArrayList<Feed> = ArrayList()
        //Head
        feeds.add(Feed())


        //Story
        feeds.add(Feed(stories))

        //Post
        for (i in 0..5){
            feeds.add(Feed(Post(R.drawable.img_profile, "Mr Mansur", R.drawable.img_profile)))
        }

        return feeds
    }
    fun openPOST(){
        startActivity(Intent(this,POSTActivity::class.java))
    }
}