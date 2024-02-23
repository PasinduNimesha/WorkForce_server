package com.workforcepro.server.config

import com.workforcepro.server.repository.ApplicationRepository
import com.workforcepro.server.repository.EmployeeRepository
import com.workforcepro.server.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration

class Config {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun userRepository(): UserRepository {
        return UserRepository()
    }

    @Bean
    fun employeeRepository(): EmployeeRepository {
        return EmployeeRepository()
    }

    @Bean
    fun applicationRepository(): ApplicationRepository {
        return ApplicationRepository()
    }


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}