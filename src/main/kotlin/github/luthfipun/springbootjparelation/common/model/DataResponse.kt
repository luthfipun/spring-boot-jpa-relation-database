package github.luthfipun.springbootjparelation.common.model

import org.springframework.http.HttpStatus

data class DataResponse<T>(
    val status: Int = HttpStatus.OK.value(),
    val message: String = HttpStatus.OK.name,
    val data: T? = null
)