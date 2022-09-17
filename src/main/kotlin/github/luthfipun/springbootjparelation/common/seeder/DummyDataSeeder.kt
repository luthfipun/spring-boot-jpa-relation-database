package github.luthfipun.springbootjparelation.common.seeder

import github.luthfipun.springbootjparelation.product.entity.Product
import github.luthfipun.springbootjparelation.product.service.ProductService
import github.luthfipun.springbootjparelation.user.entity.User
import github.luthfipun.springbootjparelation.user.service.UserService
import github.luthfipun.springbootjparelation.wallet.entity.Wallet
import github.luthfipun.springbootjparelation.wallet.service.WalletService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DummyDataSeeder(
    val userService: UserService,
    val walletService: WalletService,
    val productService: ProductService
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
            user = userService.findById(1).get()
        )

        val wallet2 = Wallet(
            name = "Bank Transfer",
            user = userService.findById(2).get()
        )

        val wallet3 = Wallet(
            name = "Credit Card",
            user = userService.findById(3).get()
        )
        val wallets = listOf(wallet1, wallet2, wallet3)
        walletService.saveAll(wallets)

        // Product Dummy
        val product1User1 = Product(
            name = "Macbook Pro 2018",
            price = 1000.0,
            qty = 100,
            user = userService.findById(1).get()
        )

        val product2User1 = Product(
            name = "Macbook Pro 2022",
            price = 3500.0,
            qty = 50,
            user = userService.findById(1).get()
        )

        val product3User1 = Product(
            name = "IPhone 12 Pro Max",
            price = 1800.0,
            qty = 10,
            user = userService.findById(1).get()
        )

        val product1User2 = Product(
            name = "IPhone 11",
            price = 1100.0,
            qty = 20,
            user = userService.findById(2).get()
        )

        val product2User2 = Product(
            name = "IPad 2020",
            price = 1350.0,
            qty = 5,
            user = userService.findById(2).get()
        )

        val product1User3 = Product(
            name = "Airpods Pro",
            price = 750.0,
            qty = 15,
            user = userService.findById(3).get()
        )

        val product2User3 = Product(
            name = "Apple Watch SE 2020",
            price = 445.0,
            qty = 5,
            user = userService.findById(3).get()
        )
        productService.saveAll(listOf(
            product1User1, product2User1, product3User1,
            product1User2, product2User2,
            product1User3, product2User3
        ))
    }
}
































