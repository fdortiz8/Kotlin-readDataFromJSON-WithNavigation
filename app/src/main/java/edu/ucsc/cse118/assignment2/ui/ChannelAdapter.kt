package edu.ucsc.cse118.assignment2.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment2.R
import edu.ucsc.cse118.assignment2.data.Channel

class ChannelAdapter(private val channels: ArrayList<Channel>, private val listener: ChannelsListener)  : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ChannelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_channel, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channels[position]
        holder.bind(channel)
        holder.itemView.setOnClickListener { listener.onClick(channel) }
    }

    override fun getItemCount() : Int {
        return channels.size
    }

    class ChannelViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val messageCount : TextView = itemView.findViewById(R.id.messageCount)

        @SuppressLint("SetTextI18n")
        fun bind(channel: Channel) {
            name.text = channel.name
            messageCount.text = channel.messages?.size.toString() + " Messages"
        }
    }
}