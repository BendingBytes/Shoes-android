package com.bendingbytes.shoes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bendingbytes.shoes.R
import com.bendingbytes.shoes.domain.Shoe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoeAdapter : ListAdapter<Shoe, ShoeAdapter.ShoeViewHolder>(ShoeItemDiffCallback()) {

    private lateinit var mListener: OnItemClickListener

    interface  OnItemClickListener{
        fun onItemClick (position: Int)
    }
    fun setOnItemClickListener(listener : OnItemClickListener){
        mListener = listener
    }


    inner class ShoeViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.itemView.textViewTitle.text = "Name " + shoe.name
        holder.itemView.textViewPrice.text = "Price: $" + shoe.price
        Glide.with(holder.itemView).load(shoe.image).into(holder.itemView.imageViewShoe)
    }
}

class ShoeItemDiffCallback : DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldShoe: Shoe, newShoe: Shoe): Boolean = oldShoe == newShoe

    override fun areContentsTheSame(oldShoe: Shoe, newShoe: Shoe): Boolean = oldShoe == newShoe
}