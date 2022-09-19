package github.luthfipun.springbootjparelation.order.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.order.model.OrderResponse

interface OrderRepository {
    fun get(userId: Long): DataResponse<List<OrderResponse>>
}