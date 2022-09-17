package github.luthfipun.springbootjparelation.product.controller

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.product.model.ProductResponse
import github.luthfipun.springbootjparelation.product.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class ProductController(
    val productRepository: ProductRepository
) {
    @GetMapping(
        value = ["{userId}/product"],
        produces = ["application/json"]
    )
    fun get(@PathVariable("userId") userId: Long): DataResponse<List<ProductResponse>> {
        return productRepository.get(userId = userId)
    }
}