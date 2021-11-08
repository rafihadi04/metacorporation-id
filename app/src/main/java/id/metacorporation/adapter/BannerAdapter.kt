package id.metacorporation.adapter

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
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
            .load(listProgram[position].urlBannerImage?:listProgram[position].resourceBanner)
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
        bottomSheetDialog.findViewById<TextView>(R.id.detilJadwalProgramTv)!!.text =
            listProgram[position].jadwal
        bottomSheetDialog.findViewById<TextView>(R.id.ratingProgramUmurTv)!!.text =
            listProgram[position].rating
        bottomSheetDialog.findViewById<TextView>(R.id.detilJenisProgram)!!.text =
            listProgram[position].jenisProgram
        bottomSheetDialog.findViewById<TextView>(R.id.detilPembawaAcara)!!.text =
            listProgram[position].detilPembawaAcara.uppercase()

        Glide.with(context)
            .load(listProgram[position].fotoPembawaAcara)
            .diskCacheStrategy( DiskCacheStrategy.ALL )
            .into(bottomSheetDialog.findViewById<ImageView>(R.id.ivPembawaAcara)!!)

        //val lyt = bottomSheetDialog.findViewById<LinearLayout>(R.id.layoutDetilProgram)
        //bottomSheetDialog.behavior.peekHeight = 100

        val ytView = bottomSheetDialog.findViewById<YouTubePlayerView>(R.id.youtubeView)
        val imageView = bottomSheetDialog.findViewById<ImageView>(R.id.bannerProgram)
        val rvKru = bottomSheetDialog.findViewById<RecyclerView>(R.id.rvJobdesk)
        rvKru?.adapter = PresenterAdapter(
            context,
            listProgram[position].kruJobdesk
        )
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
            else -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(listProgram[position].urlBannerImage?:listProgram[position].resourceBanner)
                    .centerCrop()
                    .diskCacheStrategy( DiskCacheStrategy.ALL )
                    .into(imageView)
            }
            /*listProgram[position].resource!=0 -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(listProgram[position].resourceBanner)
                    .centerCrop()
                    .diskCacheStrategy( DiskCacheStrategy.ALL )
                    .into(imageView)
            }*/
        }
        bottomSheetDialog.show()
        bottomSheetDialog.behavior.state=BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.behavior.isFitToContents=true
    }
}