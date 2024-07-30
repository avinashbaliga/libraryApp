package com.avinash.libraryapp.responseModels


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListOfBooksItem(
    @SerialName("available")
    val available: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String
)