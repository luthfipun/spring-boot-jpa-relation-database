package github.luthfipun.springbootjparelation.product.entity

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
    val qty: Int
)