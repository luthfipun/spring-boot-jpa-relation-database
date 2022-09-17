package github.luthfipun.springbootjparelation.product.entity

import github.luthfipun.springbootjparelation.product.model.ProductResponse
import github.luthfipun.springbootjparelation.user.entity.User
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Column(name = "qty")
    val qty: Int,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = ForeignKey(name = "fk_product_user_id"))
    val user: User
){
    fun toProductResponse(): ProductResponse {
        return ProductResponse(
            id = this.id!!,
            name = this.name,
            price = this.price,
            qty = this.qty
        )
    }
}