package id.metacorporation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.smarteist.autoimageslider.SliderViewAdapter
import id.metacorporation.R
import id.metacorporation.models.ProgramModel


class BannerAdapter(
    val context :Context?,
    val listProgram:ArrayList<ProgramModel>
    ):
    SliderViewAdapter<BannerAdapter.BannerAdapterViewHolder>() {

    inner class BannerAdapterViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {
        internal var imageViewBackground :ImageView
        internal var description :TextView
        init{
            imageViewBackground = itemView!!.findViewById(R.id.iv_auto_image_slider)
            description = itemView.findViewById(R.id.tv_auto_image_slider)
        }
    }

    override fun getCount(): Int {
        return listProgram.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): BannerAdapterViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.banner_layout,null)
        return BannerAdapterViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: BannerAdapterViewHolder?, position: Int) {

        Glide.with(context!!)
            .load(listProgram[position].urlBannerImage)
            .centerCrop()
            .diskCacheStrategy( DiskCacheStrategy.ALL )
            .into(viewHolder!!.imageViewBackground)

        viewHolder.imageViewBackground.setOnClickListener{
            bannerOnClick(position)
        }


    }

    private fun bannerOnClick(position: Int) {
        val bottomSheetDialog = BottomSheetDialog(context!!)

        bottomSheetDialog.setContentView(R.layout.deskripsi_program_layout)
        bottomSheetDialog.findViewById<TextView>(R.id.tv_program_title)!!.text =
            listProgram[position].namaProgram.uppercase()
        bottomSheetDialog.findViewById<TextView>(R.id.tv_program_deskripsi)!!.text =
            listProgram[position].deskripsiProgram
        val ytView = bottomSheetDialog.findViewById<YouTubePlayerView>(R.id.youtubeView)
        val imageView = bottomSheetDialog.findViewById<ImageView>(R.id.bannerProgram)
        when {
            listProgram[position].urlTeaser.isNotEmpty() -> {
                imageView!!.visibility=View.GONE
                ytView!!.visibility=View.VISIBLE
                ytView.initialize(object : AbstractYouTubePlayerListener(){
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.cueVideo(listProgram[position].urlTeaser,0F)
                    }
                })
            }
            listProgram[position].urlBannerImage.isNotEmpty() -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(listProgram[position].urlBannerImage)
                    .centerCrop()
                    .into(imageView)
            }
            listProgram[position].resource!=0 -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(listProgram[position].resource)
                    .centerCrop()
                    .into(imageView)
            }
        }
        bottomSheetDialog.show()
    }
}