package github.luthfipun.springbootjparelation.common.controller

import github.luthfipun.springbootjparelation.common.model.DataResponse
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException.InternalServerError
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ErrorController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NoHandlerFoundException::class])
    fun notFoundHandler(notFoundException: NoHandlerFoundException): DataResponse<Nothing>{
        return DataResponse(
            status = HttpStatus.NOT_FOUND.value(),
            message = HttpStatus.NOT_FOUND.name
        )
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [InternalServerError::class])
    fun serverErrorHandler(internalServerError: InternalServerError): DataResponse<Nothing>{
        return DataResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = internalServerError.message.orEmpty()
        )
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [EmptyResultDataAccessException::class])
    fun resultEmptyHandler(emptyResultDataAccessException: EmptyResultDataAccessException): DataResponse<Nothing>{
        return DataResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = emptyResultDataAccessException.message.orEmpty()
        )
    }
}