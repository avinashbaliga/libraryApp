package com.avinash.libraryapp.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

object ManageScopes {
    fun getCoroutineScope() = CoroutineScope(Dispatchers.Default)
}