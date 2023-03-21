package com.sachet.PaymentService.model

import org.springframework.http.HttpStatus

class ErrorMessage(
    var message: String ?= null,
    var errorCode: String ?= null,
    var status: HttpStatus ?= null
)
