package com.workforcepro.server.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig {
    @Bean
    @Throws(Exception::class)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { auth ->
            auth.requestMatchers("/user/list/**").permitAll().anyRequest().permitAll()
        }

        return http.build()
    }
}