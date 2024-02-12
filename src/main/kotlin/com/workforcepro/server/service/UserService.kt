package com.workforcepro.server.service

import com.workforcepro.server.dto.UserDto
import com.workforcepro.server.entity.User
import com.workforcepro.server.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository,
    private val modelMapper: ModelMapper

){

    init {
        modelMapper.typeMap(User::class.java, User::class.java)

    }
    fun getAllUsers(): List<UserDto> {
        return userRepository.getAllUsers().map { modelMapper.map(it, UserDto::class.java) }
    }
    fun getUserById(id: Long): UserDto {
        return modelMapper.map(userRepository.getUserById(id), UserDto::class.java)
    }



}