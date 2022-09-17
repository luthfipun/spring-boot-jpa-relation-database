package github.luthfipun.springbootjparelation.user.entity

import github.luthfipun.springbootjparelation.user.model.UserResponse
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "email", unique = true)
    val email: String
){
    fun toUserResponse(): UserResponse {
        return UserResponse(
            id = this.id!!,
            name = this.name,
            email = this.email
        )
    }
}