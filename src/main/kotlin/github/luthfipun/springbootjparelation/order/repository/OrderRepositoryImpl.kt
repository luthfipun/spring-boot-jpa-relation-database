package github.luthfipun.springbootjparelation.order.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.order.model.OrderResponse
import github.luthfipun.springbootjparelation.order.service.OrderService
import github.luthfipun.springbootjparelation.user.service.UserService
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    val orderService: OrderService,
    val userService: UserService
) : OrderRepository {
    override fun get(userId: Long): DataResponse<List<OrderResponse>> {
        val user = userService.findById(userId)
        val order = orderService.findByUser(user = user.get())

        if (order.isEmpty()){
            throw Exception("Empty data!")
        }

        return DataResponse(data = order.map { it.toOrderResponse() })
    }
}