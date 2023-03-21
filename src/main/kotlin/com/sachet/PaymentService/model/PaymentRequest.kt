package com.sachet.PaymentService.model

class PaymentRequest(
    var orderId: Long ?= null,
    var amount: Long ?= null,
    var referenceNumber: String ?= null,
    var paymentMode: PaymentMode ?= null
)