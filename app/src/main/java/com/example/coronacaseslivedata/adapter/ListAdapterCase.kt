package com.example.coronacaseslivedata.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coronacaseslivedata.R
import com.example.coronacaseslivedata.jdo.Cases

class ListAdapter(var mContext: Context, var mCaseList: List<Cases>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View =
            LayoutInflater.from(mContext).inflate(R.layout.activity_cases_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCaseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mConfirmed.text = mCaseList[position].mTotalAffected
        holder.mCountry.text = mCaseList[position].mCountry
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCountry: TextView = itemView.findViewById(R.id.country)
        var mConfirmed: TextView = itemView.findViewById(R.id.confirmed)
    }

}