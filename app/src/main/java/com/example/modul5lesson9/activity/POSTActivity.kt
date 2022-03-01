package com.example.modul5lesson9.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.modul5lesson9.R

class POSTActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postactivity)

        initViews()
    }

    private fun initViews(){
        val toBack = findViewById<ImageView>(R.id.iv_img_on_mind)
        val addPost = findViewById<TextView>(R.id.tv_add_post)
        val edittext = findViewById<EditText>(R.id.et_on_mind)
        val image = findViewById<ImageView>(R.id.iv_img_on_mind)
        val close = findViewById<ImageView>(R.id.iv_close_on_mind)
        val link = findViewById<TextView>(R.id.tv_link_on_mind)
        val name = findViewById<TextView>(R.id.tv_post_name_on_mind)



        addPost.setOnClickListener {

        }
    }
}