package com.sachet.PaymentService.service.impl

import com.sachet.PaymentService.entity.TransactionDetails
import com.sachet.PaymentService.exception.CustomException
import com.sachet.PaymentService.model.PaymentRequest
import com.sachet.PaymentService.repository.TransactionDetailsRepository
import com.sachet.PaymentService.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.Instant

@Service
class PaymentServiceImpl(
    val transactionDetailsRepository: TransactionDetailsRepository
) : PaymentService {
    override fun doPayment(paymentRequest: PaymentRequest): Long? {
        val transactionDetails = TransactionDetails().apply {
            paymentDate = Instant.now()
            paymentMode = paymentRequest.paymentMode.toString()
            paymentStatus = "SUCCESS"
            orderId = paymentRequest.orderId
            referenceNumber = paymentRequest.referenceNumber
            amount = paymentRequest.amount
        }
        return transactionDetailsRepository.save(transactionDetails).id
    }

    override fun getTransaction(id: Long): TransactionDetails {
        val transaction = transactionDetailsRepository.findById(id)
        if (!transaction.isPresent) throw CustomException(
            errorMessage = "Transaction with Id $id Not Found",
            errorCode = "TRANSACTION_NOT_FOUND",
            status = HttpStatus.NOT_FOUND
        )
        return transaction.get()
    }
}