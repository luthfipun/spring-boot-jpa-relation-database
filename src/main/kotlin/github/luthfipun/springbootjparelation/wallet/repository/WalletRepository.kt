package github.luthfipun.springbootjparelation.wallet.repository

import github.luthfipun.springbootjparelation.common.model.DataResponse
import github.luthfipun.springbootjparelation.wallet.model.WalletResponse

interface WalletRepository {
    fun get(userId: Long): DataResponse<WalletResponse>
}