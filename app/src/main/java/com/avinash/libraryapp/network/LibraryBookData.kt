package com.avinash.libraryapp.network

import android.util.Log
import com.avinash.libraryapp.responseModels.ListOfBooksItem
import com.avinash.libraryapp.utils.ManageScopes
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.async
import kotlinx.coroutines.withTimeout

class LibraryBookData {

    companion object {
        private var listOfBookItems: List<ListOfBooksItem>? = null
        suspend fun getListOfBooks(): List<ListOfBooksItem>? {
            ManageScopes.getCoroutineScope().async {
                withTimeout(5000) {
                    try {
                        listOfBookItems = NetworkHandle().getHttpClient().get {
                            url(ApiConstants.BASE_URL + ApiConstants.LIST_OF_BOOKS)
                        }.body()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }.await()

            Log.i("Library book data", listOfBookItems.toString())
            return listOfBookItems
        }
    }
}