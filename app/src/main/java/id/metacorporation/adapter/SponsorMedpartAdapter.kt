package id.metacorporation.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.metacorporation.R

class SponsorMedpartAdapter(val context:Context, val listRes:ArrayList<Int>) : RecyclerView.Adapter<SponsorMedpartAdapter.VH>() {

    inner class VH(val itemView: View) : RecyclerView.ViewHolder(itemView){
        val image :ImageView = itemView as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ImageView(context)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.image.layoutParams = ViewGroup.MarginLayoutParams(context.resources.getDimensionPixelSize(R.dimen.bronze_Sponsor),context.resources.getDimensionPixelSize(R.dimen.bronze_Sponsor))
        (holder.image.layoutParams as ViewGroup.MarginLayoutParams).setMargins(context.resources.getDimensionPixelSize(R.dimen._10sdp))
        Glide.with(context)
            .load(listRes[position])
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return listRes.size
    }
}