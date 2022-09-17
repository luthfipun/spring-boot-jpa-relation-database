package github.luthfipun.springbootjparelation.product.service

import github.luthfipun.springbootjparelation.product.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductService: JpaRepository<Product, Long> {
    fun findByUserId(userId: Long): List<Product>
}