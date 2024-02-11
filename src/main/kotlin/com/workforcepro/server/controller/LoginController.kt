package com.workforcepro.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class LoginController {
    @PostMapping("/login")
    fun login(@RequestBody body: Map<String, String>): String {
        val message = "Login successful" + "\n Welcome ${body["username"]}"
        return message
    }
}