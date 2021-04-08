package com.liverpool.app.data.exceptions

class ApiException @JvmOverloads constructor(
        val code: Int,
        message: String,
        cause: Throwable? = null
) : Throwable(message, cause)