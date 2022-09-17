package github.luthfipun.springbootjparelation.product.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.product.model.ProductResponse
import github.luthfipun.springbootjparelation.product.service.ProductService
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    val productService: ProductService
) : ProductRepository {
    override fun get(userId: Long): DataResponse<List<ProductResponse>> {
        return DataResponse(
            data = productService.findByUserId(userId = userId)
                .map { it.toProductResponse() }
        )
    }
}