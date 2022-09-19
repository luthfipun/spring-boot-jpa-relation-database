package github.luthfipun.springbootjparelation.user.service

import github.luthfipun.springbootjparelation.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserService: JpaRepository<User, Long>