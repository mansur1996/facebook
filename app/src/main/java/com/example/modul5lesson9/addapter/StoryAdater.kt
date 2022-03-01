package com.example.modul5lesson9.addapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson9.R
import com.example.modul5lesson9.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdater(var context: Context, var items : ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story_view,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if(holder is StoryViewHolder){
            holder.apply {
                iv_background.setImageResource(story.profile)
                iv_profile.setImageResource(story.profile)
                tv_fullname.text = story.fullname
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class StoryViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var iv_background = view.findViewById<ShapeableImageView>(R.id.iv_background_view)
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile_view)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname_view)
    }
}