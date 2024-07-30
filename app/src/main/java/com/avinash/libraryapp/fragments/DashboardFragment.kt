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
import com.avinash.libraryapp.recyclerViewAdapters.NewBookRvAdapter
import com.avinash.libraryapp.viewModels.DashboardFragmentViewModel

class DashboardFragment : Fragment() {

    private lateinit var dashboardBinding: FragmentDashboardBinding
    private lateinit var dashboardFragmentViewModel: DashboardFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        initiateNewBookView()
        initiateDashboardViewModel()
        assignDataObservers()
        return dashboardBinding.root
    }

    private fun initiateNewBookView() {
        var newBookRecyclerView: RecyclerView = dashboardBinding.newBookRV
        newBookRecyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        newBookRecyclerView.adapter = NewBookRvAdapter()
    }

    private fun assignDataObservers() {
        dashboardFragmentViewModel.getListOfBooks().observe(viewLifecycleOwner) { newValue ->
            if (newValue != null)
                Log.i("DashboardFragment", newValue.toString())
        }
    }

    private fun initiateDashboardViewModel() {
        dashboardFragmentViewModel =
            ViewModelProvider(this).get(DashboardFragmentViewModel::class.java)
    }
}