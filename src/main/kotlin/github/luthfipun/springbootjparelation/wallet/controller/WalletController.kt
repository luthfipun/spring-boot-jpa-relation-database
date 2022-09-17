package github.luthfipun.springbootjparelation.wallet.controller

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.wallet.model.WalletResponse
import github.luthfipun.springbootjparelation.wallet.repository.WalletRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class WalletController(
    val walletRepository: WalletRepository
) {
    @GetMapping(
        value = ["{userId}/wallet"],
        produces = ["application/json"]
    )
    fun get(@PathVariable("userId") userId: Long): DataResponse<WalletResponse> {
        return walletRepository.get(userId = userId)
    }
}