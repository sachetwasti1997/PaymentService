package com.sachet.PaymentService.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
class TransactionDetails (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var orderId: Long ?= null,
    var paymentMode: String ?= null,
    var referenceNumber: String ?= null,
    var paymentDate: Instant ?= null,
    var paymentStatus: String ?= null,
    var amount: Long ?= null
)