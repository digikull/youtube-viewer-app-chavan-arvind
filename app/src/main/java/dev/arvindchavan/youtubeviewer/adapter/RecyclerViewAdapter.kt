package dev.arvindchavan.youtubeviewer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import dev.arvindchavan.youtubeviewer.R
import dev.arvindchavan.youtubeviewer.model.Video

class RecyclerViewAdapter(
    private val item_list : ArrayList<Video>,
    private val onClickListener : OnClickListener,
    private val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tittle : TextView = itemView.findViewById(R.id.video_title)
        val thumbnail : ImageView = itemView.findViewById(R.id.video_thumbnail)
        val parent : MaterialCardView = itemView.findViewById(R.id.parent)


        init {

            parent.setOnClickListener {

                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){

                    onClickListener.onItemClick(position)
                }
            }
        }
    }

    interface OnClickListener{

        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video_data = item_list[position]

        holder.tittle.text = video_data.tittle

        Glide.with(context).load(video_data.thumbnail).into(holder.thumbnail)
    }

    override fun getItemCount(): Int = item_list.size
}