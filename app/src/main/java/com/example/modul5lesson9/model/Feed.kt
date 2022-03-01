package com.example.modul5lesson9.model

class Feed {
    var isHeader : Boolean = false
    var post : Post? = null
    var stories : ArrayList<Story> = ArrayList()

    constructor(){
        this.isHeader = true
    }

    constructor(post: Post){
        this.post = post
        this.isHeader = false
    }

    constructor(story: ArrayList<Story>){
        this.stories = story
        this.isHeader = false
    }
}