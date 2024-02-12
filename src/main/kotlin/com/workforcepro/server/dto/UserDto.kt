package com.workforcepro.server.dto



class UserDto {
    var id: Long = 0;
    var username: String = ""
    var password: String = ""
    var email: String = ""
    var role: String = ""
    var enabled: Boolean = false
    var accountNonExpired: Boolean = false
    var credentialsNonExpired: Boolean = false
    var accountNonLocked: Boolean = false

}