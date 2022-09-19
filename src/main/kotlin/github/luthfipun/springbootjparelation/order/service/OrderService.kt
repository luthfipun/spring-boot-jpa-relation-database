package github.luthfipun.springbootjparelation.order.service

import github.luthfipun.springbootjparelation.order.entity.Order
import github.luthfipun.springbootjparelation.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface OrderService: JpaRepository<Order, Long> {
    fun findByUser(user: User): List<Order>
}