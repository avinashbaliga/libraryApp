package com.avinash.libraryapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avinash.libraryapp.databinding.FragmentDashboardBinding
import com.avinash.libraryapp.recyclerViewAdapters.AllBookRvAdapter
import com.avinash.libraryapp.recyclerViewAdapters.NewBookRvAdapter
import com.avinash.libraryapp.responseModels.ListOfBooksItem
import com.avinash.libraryapp.viewModels.DashboardFragmentViewModel

class DashboardFragment : Fragment() {

    private lateinit var dashboardBinding: FragmentDashboardBinding
    private lateinit var dashboardFragmentViewModel: DashboardFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        initiateDashboardViewModel()
        assignDataObservers()
        return dashboardBinding.root
    }

    private fun initiateNewBookView(listOfItems: List<ListOfBooksItem>) {
        var newBookRecyclerView: RecyclerView = dashboardBinding.newBookRV
        newBookRecyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        newBookRecyclerView.adapter = NewBookRvAdapter(listOfItems)
    }

    private fun initiateAllBooksView(listOfBooksItem: List<ListOfBooksItem>) {
        var allBooksRecyclerView: RecyclerView = dashboardBinding.allBooksRV
        allBooksRecyclerView.layoutManager = LinearLayoutManager(this.context)
        allBooksRecyclerView.adapter = AllBookRvAdapter(listOfBooksItem)
    }

    private fun assignDataObservers() {
        dashboardFragmentViewModel.getListOfBooks().observe(viewLifecycleOwner) { newValue ->
            if (newValue != null) {
                Log.i("DashboardFragment", newValue.toString())
                drawRecyclerViewWithData(newValue)
                drawAllBooksRecyclerViewWithData(newValue)
            }
        }
    }

    private fun initiateDashboardViewModel() {
        dashboardFragmentViewModel =
            ViewModelProvider(this).get(DashboardFragmentViewModel::class.java)
    }

    private fun drawRecyclerViewWithData(listOfItems: List<ListOfBooksItem>) {
        initiateNewBookView(listOfItems)
    }

    private fun drawAllBooksRecyclerViewWithData(bookDetails: List<ListOfBooksItem>) {
        initiateAllBooksView(bookDetails)
    }
}