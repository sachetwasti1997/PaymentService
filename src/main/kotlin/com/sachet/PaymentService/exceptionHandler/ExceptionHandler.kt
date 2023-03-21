package com.sachet.PaymentService.exceptionHandler

import com.sachet.PaymentService.exception.CustomException
import com.sachet.PaymentService.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(CustomException::class)
    @ResponseBody
    fun handleNotFoundException(ex: CustomException): ResponseEntity<ErrorMessage> {
        return ResponseEntity(
            ErrorMessage(message = ex.message, errorCode = ex.errorCode, status = ex.status),
            ex.status
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun genericException(exception: Exception): ErrorMessage {
        return ErrorMessage(message = exception.message, status = HttpStatus.INTERNAL_SERVER_ERROR)
    }
}