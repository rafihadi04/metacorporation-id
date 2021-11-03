package id.metacorporation.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.TextView
import id.metacorporation.R

class SpinnerAdapter(private val requireContext: Activity, private val textViewRes :Int, private val listString: ArrayList<String>) :ArrayAdapter<String>(requireContext,textViewRes, R.id.spinnerText,listString){

    private val inflater :LayoutInflater = requireContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row = inflater.inflate(textViewRes,parent,false)
        val v = row.findViewById<TextView>(R.id.spinnerText)
        v.text = listString[position]
        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row = inflater.inflate(textViewRes,parent,false)
        val v = row.findViewById<TextView>(R.id.spinnerText)
        v.text = listString[position]
        return row
    }

}