package id.metacorporation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.metacorporation.R
import id.metacorporation.models.SponsorModel

class SponsorMedpartAdapter(val context:Context, private val listRes:ArrayList<SponsorModel>) : RecyclerView.Adapter<SponsorMedpartAdapter.VH>() {

    private val sizeArray = mapOf(
        Pair(SponsorModel.Companion.Size.S,context.resources.getDimensionPixelSize(R.dimen.bronze_SponsorS)),
        Pair(SponsorModel.Companion.Size.M,context.resources.getDimensionPixelSize(R.dimen.bronze_Sponsor)),
        Pair(SponsorModel.Companion.Size.L,context.resources.getDimensionPixelSize(R.dimen.bronze_SponsorL)),
        Pair(SponsorModel.Companion.Size.XL,context.resources.getDimensionPixelSize(R.dimen.bronze_SponsorXL)),
    )

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image :ImageView = itemView as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ImageView(context)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.image.layoutParams = ViewGroup.MarginLayoutParams(sizeArray[listRes[position].ukuran]!!,sizeArray[listRes[position].ukuran]!!)
        (holder.image.layoutParams as ViewGroup.MarginLayoutParams).setMargins(context.resources.getDimensionPixelSize(R.dimen._10sdp))
        Glide.with(context)
            .load(listRes[position].res)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return listRes.size
    }
}