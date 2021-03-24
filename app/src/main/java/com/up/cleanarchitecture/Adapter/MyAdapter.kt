package com.up.cleanarchitecture.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.up.cleanarchitecture.R

class MyAdapter
   constructor (name: List<String>, image: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context
    lateinit var viewHolder: RecyclerView.ViewHolder
    val myName: List<String>
    val myImage: List<String>

    init {
        myName = name
        myImage = image
    }

    class ViewHolder2(cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        var text: TextView
        var image: SimpleDraweeView

        init {
            text = cardView.findViewById<View>(R.id.text) as TextView
            image = cardView.findViewById<View>(R.id.image) as SimpleDraweeView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        context = parent.context
       var v: CardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.mycard, parent, false) as CardView
        viewHolder = ViewHolder2(v)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val mtitle: String = myName.get(position)
        val murl: String = myImage.get(position)
        val vaultItemHolder = holder as ViewHolder2
        vaultItemHolder.text.text = mtitle
        val uri = Uri.parse(murl)
        vaultItemHolder.image.setImageURI(uri,context)
    }

    override fun getItemCount(): Int {
        return myName.size
    }
}