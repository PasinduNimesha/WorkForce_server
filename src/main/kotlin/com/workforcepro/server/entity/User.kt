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
    var firstName: String = ""
    var lastName: String = ""
    var employeeId: Long = 0
    var gender: String = ""
}