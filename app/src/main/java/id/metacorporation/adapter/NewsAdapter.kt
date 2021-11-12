package id.metacorporation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.smarteist.autoimageslider.SliderViewAdapter
import id.metacorporation.R
import id.metacorporation.models.Posts
import org.apache.commons.text.StringEscapeUtils

class NewsAdapter(val context: Context, private val posts:ArrayList<Posts>): SliderViewAdapter<NewsAdapter.VH>() {
    class VH(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        internal val image = itemView.findViewById<ImageView>(R.id.iv_auto_image_slider)
        internal val text = itemView.findViewById<TextView>(R.id.tv_auto_image_slider)
    }

    override fun getCount(): Int {
        return posts.size
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup?): VH {
        return VH(
            LayoutInflater.from(context).inflate(R.layout.banner_layout_new,null)
        )
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        Glide.with(context)
            .load(posts[position].yoastHeadJson.ogImage.first().url)
            .centerCrop()
            .diskCacheStrategy( DiskCacheStrategy.ALL )
            .into(viewHolder.image)
        viewHolder.text.text = StringEscapeUtils.unescapeHtml4(posts[position].title.rendered)
    }
}