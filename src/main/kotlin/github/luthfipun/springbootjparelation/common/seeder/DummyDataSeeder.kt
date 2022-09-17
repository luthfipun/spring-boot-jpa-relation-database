package github.luthfipun.springbootjparelation.common.seeder

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
    val walletService: WalletService
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
    }
}