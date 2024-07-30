package com.avinash.libraryapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avinash.libraryapp.R
import com.avinash.libraryapp.databinding.FragmentDashboardBinding
import com.avinash.libraryapp.network.LibraryBookData
import com.avinash.libraryapp.recyclerViewAdapters.NewBookRvAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardBinding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        initiateNewBookView()
        LibraryBookData.getListOfBooks()
        return dashboardBinding.root
    }

    private fun initiateNewBookView() {
        var newBookRecyclerView: RecyclerView = dashboardBinding.newBookRV
        newBookRecyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        newBookRecyclerView.adapter = NewBookRvAdapter()
    }
}