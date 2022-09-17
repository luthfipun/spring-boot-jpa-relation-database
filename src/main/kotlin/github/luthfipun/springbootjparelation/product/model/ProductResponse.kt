package github.luthfipun.springbootjparelation.product.model

data class ProductResponse(
    val id: Long,
    val name: String,
    val price: Double,
    val qty: Int
)
