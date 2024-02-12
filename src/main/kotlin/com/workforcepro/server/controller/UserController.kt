package com.workforcepro.server.controller

import com.workforcepro.server.dto.UserDto
import com.workforcepro.server.entity.User
import com.workforcepro.server.service.UserService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(
    private val userService: UserService?,
    private val modelMapper: ModelMapper?

) {

    @GetMapping("/")
    fun getAllUsers(): List<UserDto> {
        return userService!!.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserDto> {
        val user: UserDto = userService!!.getUserById(id)
        return ResponseEntity<UserDto>(user, HttpStatus.OK)
    }

}