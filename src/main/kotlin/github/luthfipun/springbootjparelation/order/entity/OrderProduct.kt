package github.luthfipun.springbootjparelation.order.entity

import github.luthfipun.springbootjparelation.order.model.OrderProductResponse
import github.luthfipun.springbootjparelation.product.entity.Product
import javax.persistence.*

@Entity
@Table(name = "order_product")
data class OrderProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product,

    @Column(name = "price")
    val price: Double,

    @Column(name = "qty")
    val qty: Int
){
    fun toOrderProductResponse(): OrderProductResponse {
        return OrderProductResponse(
            id = this.id!!,
            price = this.price,
            qty = this.qty,
            productName = this.product.name
        )
    }
}
