package com.avinash.libraryapp.network

import com.avinash.libraryapp.responseModels.ListOfBooksItem
import com.avinash.libraryapp.utils.ManageScopes
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LibraryBookData {

    companion object {

        fun getListOfBooks(): List<ListOfBooksItem>? {
            var listOfBookItems: List<ListOfBooksItem>? = null
            ManageScopes.getCoroutineScope().launch {
                listOfBookItems = NetworkHandle().getHttpClient().get {
                    url(ApiConstants.BASE_URL+ApiConstants.LIST_OF_BOOKS)
                }.body()
            }

            println(listOfBookItems)
            println(listOfBookItems?.size)

            return listOfBookItems
        }
    }
}