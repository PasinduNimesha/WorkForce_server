package com.workforcepro.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.net.http.HttpResponse

@RestController
class LoginController {
    @PostMapping("/login")
    fun login(@RequestBody body: Map<String, String>): ResponseEntity<String> {
        val message = "Login successful" + "\nWelcome ${body["username"]}"
        //response set to 200

        return ResponseEntity(message, HttpStatus.OK)
    }
}