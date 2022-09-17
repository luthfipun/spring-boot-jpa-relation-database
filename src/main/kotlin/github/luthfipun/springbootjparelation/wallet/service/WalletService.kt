package github.luthfipun.springbootjparelation.wallet.service

import github.luthfipun.springbootjparelation.wallet.entity.Wallet
import org.springframework.data.jpa.repository.JpaRepository

interface WalletService: JpaRepository<Wallet, Long> {
    fun findByUserId(userId: Long): Wallet
}