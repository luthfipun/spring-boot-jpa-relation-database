package github.luthfipun.springbootjparelation.product.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.product.model.ProductResponse

interface ProductRepository {
    fun get(userId: Long): DataResponse<List<ProductResponse>>
}