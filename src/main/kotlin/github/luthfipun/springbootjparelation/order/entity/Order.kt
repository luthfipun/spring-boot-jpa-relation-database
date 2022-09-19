package github.luthfipun.springbootjparelation.order.entity

import github.luthfipun.springbootjparelation.order.model.OrderResponse
import github.luthfipun.springbootjparelation.user.entity.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "createdAt")
    val createdAt: Date,

    @Column(name = "updatedAt", nullable = true)
    val updatedAt: Date? = null,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderProduct: MutableList<OrderProduct> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", foreignKey = ForeignKey(name = "fk_order_user"))
    val user: User
){
    fun toOrderResponse(): OrderResponse {
        return OrderResponse(
            id = this.id!!,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt,
            orderProduct = this.orderProduct.map {
                it.toOrderProductResponse()
            }
        )
    }
}
