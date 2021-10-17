package id.metacorporation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import id.metacorporation.R
import id.metacorporation.enum.SosmedType
import id.metacorporation.models.PresenterModel

class PresenterAdapter(
    val context: Context?,
    val presenterList :ArrayList<PresenterModel>,
    ):RecyclerView.Adapter<PresenterAdapter.PresenterAdapterVH>() {
    inner class PresenterAdapterVH(val itemView: View) :RecyclerView.ViewHolder(itemView){
        internal var imageProfile :ImageView
        internal var namaPresenter :TextView
        init {
            imageProfile = itemView.findViewById(R.id.iv_program)
            namaPresenter = itemView.findViewById(R.id.tv_program)
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresenterAdapterVH {
        var inflater :View? = null
        inflater = LayoutInflater.from(parent.context).inflate(R.layout.presenter_layout,null)

        return PresenterAdapterVH(inflater!!)
    }

    override fun onBindViewHolder(holder: PresenterAdapterVH, position: Int) {

        holder.namaPresenter.text = presenterList[position].nama

        Glide.with(context!!)
            .load(presenterList[position].resourceImage)
            .centerCrop()
            .diskCacheStrategy( DiskCacheStrategy.ALL )
            .into(holder.imageProfile)


        holder.imageProfile.setOnClickListener{
            presenterOnClick(position)
        }

        /*if(tipe == ProgramAdapterType.PRESENTER){
            bottomSheetDialog.setContentView(R.layout.deskripsi_layout)
            bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_title)!!.text = presenterList!![position].jenisSosmed.also {
                when(it){
                    SosmedType.TWITTER -> "Twitter"
                    SosmedType.INSTAGRAM -> "Instagram"
                    SosmedType.FACEBOOK -> "Facebook"
                    SosmedType.TIKTOK -> "Tiktok"
                    SosmedType.WHATSAPP -> "WhatsApp"
                    SosmedType.YOUTUBE -> "Youtube"
                    else -> "null"
                }
            }.toString()
            bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_deskripsi)!!.text = presenterList[position].deskripsiSosmed
            bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_username)!!.text = presenterList[position].usernameSosmed
            //iv_presenter_profile
        }else{

        }*/



    }

    private fun presenterOnClick(position: Int) {
        val bottomSheetDialog = BottomSheetDialog(context!!)

        bottomSheetDialog.setContentView(R.layout.deskripsi_layout)
        bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_title)!!.text =
            presenterList[position].jenisSosmed.also {
                when (it) {
                    SosmedType.TWITTER -> context.getString(R.string.twitter)
                    SosmedType.INSTAGRAM -> context.getString(R.string.instagram)
                    SosmedType.FACEBOOK -> context.getString(R.string.facebook)
                    SosmedType.TIKTOK -> context.getString(R.string.tiktok)
                    SosmedType.WHATSAPP -> context.getString(R.string.whatsapp)
                    SosmedType.YOUTUBE -> context.getString(R.string.youtube)
                    else -> "null"
                }
            }.toString()
        bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_deskripsi)!!.text =
            presenterList[position].deskripsiSosmed
        bottomSheetDialog.findViewById<TextView>(R.id.tv_sosmed_username)!!.text =
            presenterList[position].usernameSosmed
        bottomSheetDialog.show()
    }

    override fun getItemCount(): Int {
        return presenterList.size
    }
}