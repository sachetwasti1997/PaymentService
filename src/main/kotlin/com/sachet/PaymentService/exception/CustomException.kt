package com.sachet.PaymentService.exception

import org.springframework.http.HttpStatus

class CustomException(
    private val errorMessage: String,
    val errorCode: String,
    val status: HttpStatus
) : RuntimeException(errorMessage)