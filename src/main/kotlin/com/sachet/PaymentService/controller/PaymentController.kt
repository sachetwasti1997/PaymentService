package com.sachet.PaymentService.controller

import com.sachet.PaymentService.model.PaymentRequest
import com.sachet.PaymentService.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController (
    val paymentService: PaymentService
){

    @PostMapping
    fun doPayment(@RequestBody paymentRequest: PaymentRequest)
    = ResponseEntity(paymentService.doPayment(paymentRequest), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getTransaction(@PathVariable id: Long)
    = ResponseEntity(paymentService.getTransaction(id), HttpStatus.OK)

}