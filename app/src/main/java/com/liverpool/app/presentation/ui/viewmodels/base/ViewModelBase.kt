package com.liverpool.app.presentation.ui.viewmodels.base

import androidx.lifecycle.ViewModel
import com.liverpool.app.data.exceptions.AppException

abstract class ViewModelBase() : ViewModel() {

    abstract fun defaultError(error: Throwable)

    fun handleError(error: Throwable) {
        if (error is AppException) {

        } else {
            this.defaultError(error)
        }
    }
}