package github.luthfipun.springbootjparelation.wallet.entity

import github.luthfipun.springbootjparelation.user.entity.User
import github.luthfipun.springbootjparelation.wallet.model.WalletResponse
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "wallet")
data class Wallet(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_user_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    val user: User
){
    fun toWalletResponse(): WalletResponse {
        return WalletResponse(
            id = this.id!!,
            name = this.name,
            user = this.user.toUserResponse()
        )
    }
}
