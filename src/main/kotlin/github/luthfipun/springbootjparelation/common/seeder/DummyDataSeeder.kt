package github.luthfipun.springbootjparelation.common.seeder

import github.luthfipun.springbootjparelation.order.entity.Order
import github.luthfipun.springbootjparelation.order.entity.OrderProduct
import github.luthfipun.springbootjparelation.order.service.OrderService
import github.luthfipun.springbootjparelation.product.entity.Product
import github.luthfipun.springbootjparelation.product.service.ProductService
import github.luthfipun.springbootjparelation.user.entity.User
import github.luthfipun.springbootjparelation.user.service.UserService
import github.luthfipun.springbootjparelation.wallet.entity.Wallet
import github.luthfipun.springbootjparelation.wallet.service.WalletService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class DummyDataSeeder(
    val userService: UserService,
    val walletService: WalletService,
    val productService: ProductService,
    val orderService: OrderService
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        // User Dummy
        val user1 = User(
            name = "John Doe",
            email = "jhon_doe@gmail.com"
        )

        val user2 = User(
            name = "Bill Gate",
            email = "billgate@gmail.com"
        )

        val user3 = User(
            name = "Mark Zukerberg",
            email = "markzukerberg@gmail.com"
        )

        val users = listOf(user1, user2, user3)
        userService.saveAll(users)

        // Wallet Dummy
        val wallet1 = Wallet(
            name = "Paypal",
            user = user1
        )

        val wallet2 = Wallet(
            name = "Bank Transfer",
            user = user2
        )

        val wallet3 = Wallet(
            name = "Credit Card",
            user = user3
        )
        val wallets = listOf(wallet1, wallet2, wallet3)
        walletService.saveAll(wallets)

        // Product Dummy
        val product1User1 = Product(
            name = "Macbook Pro 2018",
            price = 1000.0,
            qty = 100,
            user = user1
        )

        val product2User1 = Product(
            name = "Macbook Pro 2022",
            price = 3500.0,
            qty = 50,
            user = user1
        )

        val product3User1 = Product(
            name = "IPhone 12 Pro Max",
            price = 1800.0,
            qty = 10,
            user = user1
        )

        val product1User2 = Product(
            name = "IPhone 11",
            price = 1100.0,
            qty = 20,
            user = user2
        )

        val product2User2 = Product(
            name = "IPad 2020",
            price = 1350.0,
            qty = 5,
            user = user2
        )

        val product1User3 = Product(
            name = "Airpods Pro",
            price = 750.0,
            qty = 15,
            user = user3
        )

        val product2User3 = Product(
            name = "Apple Watch SE 2020",
            price = 445.0,
            qty = 5,
            user = user3
        )
        productService.saveAll(listOf(
            product1User1, product2User1, product3User1,
            product1User2, product2User2,
            product1User3, product2User3
        ))

        // Order Dummy

        val order1User1 = Order(
            createdAt = Date(),
            user = user1
        )
        orderService.save(order1User1)

        val op1order1user1 = OrderProduct(order = order1User1, product = product1User1, price = 1300.0, qty = 1)
        val op2order1user1 = OrderProduct(order = order1User1, product = product2User1, price = 2100.0, qty = 2)
        val op3order1user1 = OrderProduct(order = order1User1, product = product3User1, price = 4500.0, qty = 4)

        order1User1.orderProduct.addAll(listOf(op1order1user1, op2order1user1, op3order1user1))
        orderService.save(order1User1)

        val order2User1 = Order(
            createdAt = Date(),
            user = user1
        )
        orderService.save(order2User1)

        val op1order2user1 = OrderProduct(order = order2User1, product = product2User3, price = 4000.0, qty = 5)
        val op2order2user1 = OrderProduct(order = order2User1, product = product2User2, price = 5000.0, qty = 3)

        order2User1.orderProduct.addAll(listOf(op1order2user1, op2order2user1))
        orderService.save(order2User1)

        // --

        val order1User2 = Order(
            createdAt = Date(),
            user = user2
        )
        orderService.save(order1User2)

        val op1order1user2 = OrderProduct(order = order1User2, product = product3User1, price = 1300.0, qty = 5)
        val op2order1user2 = OrderProduct(order = order1User2, product = product2User1, price = 2100.0, qty = 2)
        val op3order1user2 = OrderProduct(order = order1User2, product = product2User3, price = 5500.0, qty = 1)

        order1User2.orderProduct.addAll(listOf(op1order1user2, op2order1user2, op3order1user2))
        orderService.save(order1User2)

        // --

        val order1User3 = Order(
            createdAt = Date(),
            user = user3
        )
        orderService.save(order1User3)

        val op1order1user3 = OrderProduct(order = order1User3, product = product2User2, price = 10500.0, qty = 10)
        order1User3.orderProduct.add(op1order1user3)
        orderService.save(order1User3)
    }
}
































