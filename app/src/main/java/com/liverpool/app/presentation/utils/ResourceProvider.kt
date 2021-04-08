package com.liverpool.app.presentation.utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class ResourceProvider @Inject constructor(private val context: Context) {
    fun getString(@StringRes id: Int): String = context.getString(id)
}