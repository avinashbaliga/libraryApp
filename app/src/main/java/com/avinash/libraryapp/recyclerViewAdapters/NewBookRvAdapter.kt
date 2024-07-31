package com.avinash.libraryapp.recyclerViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avinash.libraryapp.R
import com.avinash.libraryapp.databinding.NewBookHorizontalBinding
import com.avinash.libraryapp.responseModels.ListOfBooksItem
private lateinit var listOfBookNames: MutableMap<String, Int>
class NewBookRvAdapter(private val listOfBooksItem: List<ListOfBooksItem>) :
    RecyclerView.Adapter<NewBookRvAdapter.ViewHolder>() {

    private lateinit var newBookHorizontalBinding: NewBookHorizontalBinding

    init {
        setBookNames()
    }

    private fun setBookNames() {
        listOfBookNames = mutableMapOf()
        listOfBookNames.put("justasiam", R.drawable.justasiam)
        listOfBookNames.put("themidnightlibrary", R.drawable.themidnightlibrary)
        listOfBookNames.put("therussian", R.drawable.therussian)
        listOfBookNames.put("thevanishinghalf", R.drawable.thevanishinghalf)
        listOfBookNames.put("untamed", R.drawable.untamed)
        listOfBookNames.put("viscountwholovedme", R.drawable.viscountwholovedme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        newBookHorizontalBinding =
            NewBookHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(newBookHorizontalBinding)
    }

    override fun getItemCount(): Int {
        return listOfBooksItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.addBookDetailsToUi(listOfBooksItem[position].name, listOfBooksItem[position].type)
    }

    class ViewHolder(private val newBookBinding: NewBookHorizontalBinding) :
        RecyclerView.ViewHolder(newBookBinding.root) {

        fun addBookDetailsToUi(bookName: String, bookType: String) {
            newBookBinding.newBookNameTV.text = bookName
            newBookBinding.newBookTypeTV.text = bookType
            setBookImages(bookName)
        }

        private fun setBookImages(bookName: String) {
            listOfBookNames?.get(bookName.replace(" ", "").lowercase())
                ?.let { newBookBinding.newbook.setImageResource(it) }
        }
    }
}