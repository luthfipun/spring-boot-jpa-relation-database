package github.luthfipun.springbootjparelation.order.controller

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.order.model.OrderResponse
import github.luthfipun.springbootjparelation.order.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class OrderController(
    val orderRepository: OrderRepository
) {
    @GetMapping(
        value = ["{userId}/order"],
        produces = ["application/json"]
    )
    fun get(@PathVariable("userId") userId: Long): DataResponse<List<OrderResponse>>{
        return orderRepository.get(userId = userId)
    }
}