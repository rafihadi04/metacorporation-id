package id.metacorporation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.metacorporation.R
import id.metacorporation.models.ProgramModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Suppress("SpellCheckingInspection")
class JadwalAdapter(val context:Context?, val listProgram:ArrayList<ProgramModel>): RecyclerView.Adapter<JadwalAdapter.JadwalAdapterVH>() {
    class JadwalAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val jam :TextView = itemView.findViewById(R.id.detil_jam)
        internal val amPm :TextView = itemView.findViewById(R.id.am_pm)
        internal val namaProgram :TextView = itemView.findViewById(R.id.detil_program)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalAdapterVH {
        return JadwalAdapterVH(
            LayoutInflater.from(parent.context).inflate(R.layout.jam_program_layout,null)
        )
    }

    override fun onBindViewHolder(holder: JadwalAdapterVH, position: Int) {
        //jadwal.timeZone = TimeZone.getTimeZone("Asia/Jakarta")
        holder.jam.text = listProgram[position].jadwal.split(" Pukul ").last().split(" WIB").first()
        holder.amPm.text = "WIB"
        holder.namaProgram.text = listProgram[position].namaProgram.uppercase()

        /*holder.itemView.setOnClickListener{

        }*/
    }

    override fun getItemCount(): Int {
        return listProgram.size
    }


}