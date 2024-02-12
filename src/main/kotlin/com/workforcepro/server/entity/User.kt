package com.workforcepro.server.entity

import jakarta.persistence.*

@Entity
class User {
    @Id
    var id: Long = 0;
    var username: String = ""
    var password: String = ""
    var email: String = ""
    var role: String = ""
    var enabled: Boolean = false
    var accountNonExpired: Boolean = false
    var credentialsNonExpired: Boolean = false
    var accountNonLocked: Boolean = false
    var firstName: String = ""
    var lastName: String = ""
}