package id.metacorporation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.metacorporation.R

class KruAdapter(val listKru :ArrayList<String>): RecyclerView.Adapter<KruAdapter.KruAdapterVH>() {
    class KruAdapterVH(itemView: View) :RecyclerView.ViewHolder(itemView){
        internal val namaOrang :TextView = itemView.findViewById(R.id.jobdesk_nama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KruAdapterVH {

        return KruAdapterVH(
            LayoutInflater.from(parent.context).inflate(R.layout.kru_jobdesk_list_layout,null)
        )
    }

    override fun onBindViewHolder(holder: KruAdapterVH, position: Int) {
        holder.namaOrang.text = listKru[position]
    }

    override fun getItemCount(): Int {
        return listKru.size
    }
}