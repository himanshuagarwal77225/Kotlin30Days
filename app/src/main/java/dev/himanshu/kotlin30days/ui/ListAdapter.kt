package dev.himanshu.kotlin30days.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import dev.himanshu.kotlin30days.R
import dev.himanshu.kotlin30days.model.PhotosResponse
import kotlinx.android.synthetic.main.item_photo.view.*

class ListAdapter (
    private val list: MutableList<PhotosResponse>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoViewHolder)
            holder.bind(list[position])
    }

    fun addData(list: List<PhotosResponse>) {
        val size = this.list.size
        this.list.addAll(list)
        val newSize = this.list.size
        notifyItemRangeChanged(size, newSize)
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.image
        private val rootLayout: ConstraintLayout = itemView.rootLayout

        fun bind(item: PhotosResponse) {
            image.load(item.urls.imageUrl) {
                crossfade(true)
            }

            val set = ConstraintSet()
            set.clone(rootLayout)
            set.setDimensionRatio(image.id, "${item.width}:${item.height}")
            set.applyTo(rootLayout)
        }
    }
}