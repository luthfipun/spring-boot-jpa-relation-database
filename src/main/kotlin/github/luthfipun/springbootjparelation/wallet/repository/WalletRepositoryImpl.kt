package github.luthfipun.springbootjparelation.wallet.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.wallet.model.WalletResponse
import github.luthfipun.springbootjparelation.wallet.service.WalletService
import org.springframework.stereotype.Repository

@Repository
class WalletRepositoryImpl(
    val walletService: WalletService
) : WalletRepository {
    override fun get(userId: Long): DataResponse<WalletResponse> {
        return DataResponse(
            data = walletService.findByUserId(userId = userId).toWalletResponse()
        )
    }
}