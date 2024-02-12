package com.workforcepro.server.config

import com.workforcepro.server.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration

class Config {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun userRepo(): UserRepository {
        return UserRepository()
    }
}