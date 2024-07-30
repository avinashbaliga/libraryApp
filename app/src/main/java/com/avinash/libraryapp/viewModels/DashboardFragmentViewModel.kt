package com.avinash.libraryapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avinash.libraryapp.network.LibraryBookData
import com.avinash.libraryapp.responseModels.ListOfBooksItem
import com.avinash.libraryapp.utils.ManageScopes
import kotlinx.coroutines.async

class DashboardFragmentViewModel : ViewModel() {

    private var listOfBookItems = MutableLiveData<List<ListOfBooksItem>>()

    init {
        ManageScopes.getCoroutineScope().async {
            listOfBookItems.postValue(LibraryBookData.getListOfBooks())
        }
    }

    fun getListOfBooks() = listOfBookItems

}