package id.metacorporation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import id.metacorporation.R
import id.metacorporation.models.ProgramModel
import java.lang.RuntimeException

class ProgramAdapter(
    val context: Context?,
    val programList :ArrayList<ProgramModel>,
    ):RecyclerView.Adapter<ProgramAdapter.ProgramAdapterVH>() {
    inner class ProgramAdapterVH(private val itemView: View) :RecyclerView.ViewHolder(itemView){
        internal var imageProgram :ImageView
        internal var namaProgram :TextView
        init {
            imageProgram = itemView.findViewById(R.id.iv_program)
            namaProgram = itemView.findViewById(R.id.tv_program)
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramAdapterVH {
        val inflater :View? = LayoutInflater.from(parent.context).inflate(R.layout.program_layout,null)

        return ProgramAdapterVH(inflater!!)
    }

    override fun onBindViewHolder(holder: ProgramAdapterVH, position: Int) {

        holder.namaProgram.text = programList[position].namaProgram

        Glide.with(context!!)
            .load(programList[position].resource)
            .centerCrop()
            .diskCacheStrategy( DiskCacheStrategy.ALL )
            .into(holder.imageProgram)

        holder.imageProgram.setOnClickListener{
            programOnClick(position)
        }
    }

    private fun programOnClick(position: Int) {

        val bottomSheetDialog = BottomSheetDialog(context!!)

        bottomSheetDialog.setContentView(R.layout.deskripsi_program_layout)
        bottomSheetDialog.findViewById<TextView>(R.id.tv_program_title)!!.text =
            programList[position].namaProgram.uppercase()
        bottomSheetDialog.findViewById<TextView>(R.id.tv_program_deskripsi)!!.text =
            programList[position].deskripsiProgram

        //val lyt = bottomSheetDialog.findViewById<LinearLayout>(R.id.layoutDetilProgram)
        //bottomSheetDialog.behavior.peekHeight = 100

        val ytView = bottomSheetDialog.findViewById<YouTubePlayerView>(R.id.youtubeView)
        val imageView = bottomSheetDialog.findViewById<ImageView>(R.id.bannerProgram)
        val rvKru = bottomSheetDialog.findViewById<RecyclerView>(R.id.rvJobdesk)
        rvKru?.adapter = JobdeskAdapter(
            programList[position].kruJobdesk
        )
        when {
            programList[position].urlTeaser.isNotEmpty() -> {
                imageView!!.visibility=View.GONE
                ytView!!.visibility=View.VISIBLE
                ytView.initialize(object : AbstractYouTubePlayerListener(){
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.cueVideo(programList[position].urlTeaser,0F)
                    }
                })
            }
            programList[position].urlBannerImage.isNotEmpty() -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(programList[position].urlBannerImage)
                    .centerCrop()
                    .diskCacheStrategy( DiskCacheStrategy.ALL )
                    .into(imageView)
            }
            programList[position].resource!=0 -> {
                ytView!!.visibility=View.GONE
                imageView!!.visibility=View.VISIBLE
                Glide.with(context)
                    .load(programList[position].resource)
                    .centerCrop()
                    .diskCacheStrategy( DiskCacheStrategy.ALL )
                    .into(imageView)
            }
        }
        bottomSheetDialog.show()
    }

    override fun getItemCount(): Int {
        return programList.size
    }
}