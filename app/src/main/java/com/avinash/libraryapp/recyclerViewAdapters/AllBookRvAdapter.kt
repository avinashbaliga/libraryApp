package com.avinash.libraryapp.recyclerViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.avinash.libraryapp.R
import com.avinash.libraryapp.databinding.AllBooksVerticalBinding
import com.avinash.libraryapp.responseModels.ListOfBooksItem

private lateinit var listOfBookNames: MutableMap<String, Int>
private var cartItems: Int = 0

class AllBookRvAdapter(private val listOfBooksItem: List<ListOfBooksItem>) :
    RecyclerView.Adapter<AllBookRvAdapter.ViewHolder>() {

    private lateinit var allBooksVerticalBinding: AllBooksVerticalBinding

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
        allBooksVerticalBinding =
            AllBooksVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(allBooksVerticalBinding)
    }

    override fun getItemCount(): Int {
        return listOfBooksItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.addAllBookDetailsToUi(listOfBooksItem[position].name, listOfBooksItem[position].type)
    }

    class ViewHolder(private val allBooksVerticalBinding: AllBooksVerticalBinding) :
        RecyclerView.ViewHolder(allBooksVerticalBinding.root) {

        fun addAllBookDetailsToUi(bookName: String, bookType: String) {
            allBooksVerticalBinding.allBooksBookNameTV.text = bookName
            allBooksVerticalBinding.allBooksBookTypeTV.text = bookType
            allBooksVerticalBinding.addToCartButton.setOnClickListener {
                addAnimation(it)
                addToCart(bookName)
            }
            setAllBookImages(bookName)
        }

        private fun setAllBookImages(bookName: String) {
            listOfBookNames.get(bookName.replace(" ", "").lowercase())
                ?.let { allBooksVerticalBinding.allBooksIconIV.setImageResource(it) }
        }

        private fun addToCart(bookName: String) {
            cartItems++
            Toast.makeText(
                this.allBooksVerticalBinding.root.context,
                "$bookName has been added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }

        private fun addAnimation(view: View) {
            view.startAnimation(
                AnimationUtils.loadAnimation(
                    allBooksVerticalBinding.root.context,
                    androidx.appcompat.R.anim.abc_fade_in
                )
            )
        }
    }
}