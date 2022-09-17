package github.luthfipun.springbootjparelation.wallet.model

import github.luthfipun.springbootjparelation.user.model.UserResponse

data class WalletResponse(
    val id: Long,
    val name: String,
    val user: UserResponse
)
