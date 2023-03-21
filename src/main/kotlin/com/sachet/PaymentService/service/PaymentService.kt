package com.sachet.PaymentService.service

import com.sachet.PaymentService.entity.TransactionDetails
import com.sachet.PaymentService.model.PaymentRequest

interface PaymentService {
    fun doPayment(paymentRequest: PaymentRequest):Long?
    fun getTransaction(id: Long): TransactionDetails
}