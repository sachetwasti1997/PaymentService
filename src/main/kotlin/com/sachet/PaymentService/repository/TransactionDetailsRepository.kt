package com.sachet.PaymentService.repository

import com.sachet.PaymentService.entity.TransactionDetails
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionDetailsRepository: JpaRepository<TransactionDetails, Long>