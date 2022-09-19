package github.luthfipun.springbootjparelation.order.model

import java.util.*

data class OrderResponse(
    val id: Long,
    val createdAt: Date,
    val updatedAt: Date?,
    val orderProduct: List<OrderProductResponse>?
)

data class OrderProductResponse(
    val id: Long,
    val price: Double,
    val qty: Int,
    val productName: String
)
