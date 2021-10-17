package id.metacorporation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.metacorporation.R
import id.metacorporation.models.JobdeskModel

class JobdeskAdapter(val listJobdesk: ArrayList<JobdeskModel>): RecyclerView.Adapter<JobdeskAdapter.JobdeskAdapterVH>() {
    class JobdeskAdapterVH(itemView: View) :RecyclerView.ViewHolder(itemView) {
        internal val jobdesk :TextView = itemView.findViewById(R.id.jobdesk)
        internal val listKru :RecyclerView = itemView.findViewById(R.id.rv_kru_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobdeskAdapterVH {
        return JobdeskAdapterVH(
            LayoutInflater.from(parent.context).inflate(R.layout.kru_list_layout,null)
        )
    }

    override fun onBindViewHolder(holder: JobdeskAdapterVH, position: Int) {
        holder.jobdesk.text = listJobdesk[position].namaJobdesk
        holder.listKru.adapter = KruAdapter(
            listJobdesk[position].kru
        )
    }

    override fun getItemCount(): Int {
        return listJobdesk.size
    }
}