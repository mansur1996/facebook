package com.example.modul5lesson9.addapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson9.App
import com.example.modul5lesson9.R
import com.example.modul5lesson9.activity.MainActivity
import com.example.modul5lesson9.model.Feed
import com.example.modul5lesson9.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: MainActivity, var items : ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        if(feed.isHeader) return TYPE_ITEM_HEAD
        else if(feed.stories.size > 0) return TYPE_ITEM_STORY
        return TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_HEAD){
            return HeadViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_head, parent, false))
        }else if(viewType == TYPE_ITEM_STORY){
            return StoryViewHolder(context, LayoutInflater.from(context).inflate(R.layout.item_fead_story, parent, false))
        }
        return PostViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if(holder is HeadViewHolder){
            holder.apply {
                tvOnYourMind.setOnClickListener {
                    context.openPOST()
                }
            }
        }

        if(holder is StoryViewHolder){
            holder.apply {
                refreshAdapter(feed.stories, recyclerView)
            }
        }

        if(holder is PostViewHolder){
            holder.apply {
                iv_photo.background = App.instance.resources.getDrawable(R.drawable.img_profile)
                iv_profile.setImageResource(feed.post!!.profile)
                tv_fullname.text = feed.post!!.fullname
            }
        }
    }

    class HeadViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var tvOnYourMind = view.findViewById<TextView>(R.id.tv_on_mind)
    }

    class StoryViewHolder(context: Context, view : View) :RecyclerView.ViewHolder(view){
        var recyclerView : RecyclerView

        init {
            recyclerView = view.findViewById(R.id.rv_head_story)
            recyclerView.layoutManager = LinearLayoutManager(App.instance, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile_post)
        var iv_photo = view.findViewById<ImageView>(R.id.iv_photo_post)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname_post)
    }

    override fun getItemCount(): Int = items.size

    fun refreshAdapter(stories : ArrayList<Story>, recyclerView: RecyclerView){
        recyclerView.adapter = StoryAdater(context, stories)
    }
}