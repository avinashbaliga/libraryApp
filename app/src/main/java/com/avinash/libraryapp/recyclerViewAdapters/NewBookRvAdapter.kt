package com.avinash.libraryapp.recyclerViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avinash.libraryapp.databinding.NewBookHorizontalBinding

class NewBookRvAdapter : RecyclerView.Adapter<NewBookRvAdapter.ViewHolder>() {

    private lateinit var newBookHorizontalBinding: NewBookHorizontalBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        newBookHorizontalBinding =
            NewBookHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(newBookHorizontalBinding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(newBookBinding: NewBookHorizontalBinding) :
        RecyclerView.ViewHolder(newBookBinding.root) {
    }
}